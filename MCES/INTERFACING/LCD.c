#include<lpc214x.h>
#define PLOCK 0x00000400
#define LED_OFF (IO0SET =1U<<31)
#define LED_ON (IO0CLR=1U<<31)
#define RS_ON (IO0SET =1U<<20)
#define RS_OFF (IO0CLR=1U<<20)
#define EN_ON (IO1SET =1U<<25)
#define EN_OFF (IO1CLR=1U<<25)
void SystemInit(void)
{
 PLL0CON=0X01;
 PLL0CFG=0X24;
 PLL0FEED=0XAA;
 PLL0FEED=0X55;
 while(!(PLL0STAT & PLOCK))
 {;}
 PLL0CON=0X03;                                                                                                                                                                                                                                                                
 PLL0FEED=0XAA;
 PLL0FEED=0X55;
 VPBDIV=0x01;
}
void delay_ms(unsigned int j)
{
 unsigned int x,i;
 for(i=0;i<j;i++)
 {
  for(x=0;x<10000;x++);
 }
}
void delay_us(unsigned int count)
{ 
unsigned int j=0,i=0;
for(j=0;j<count;j++)
{
 for(i=0;i<10;i++);
}
}
void LCD_SendCmdSignals(void)
{
 RS_OFF;
 EN_ON;delay_us(100);EN_OFF;
}
void LCD_SendDataSignals(void)
{
 RS_ON;
 EN_ON;delay_us(100);EN_OFF;
}
void LCD_SendHigherNibble(unsigned char dataByte)
{
 IO0CLR=0x000F0000;
 IO0SET=((dataByte>>4)&0x0F)<<16;
}
void LCD_CmdWrite(unsigned char cmdByte)
{
 LCD_SendHigherNibble(cmdByte);
 LCD_SendCmdSignals();
 cmdByte=cmdByte<<4;
 LCD_SendHigherNibble(cmdByte);
 LCD_SendCmdSignals();
}
void LCD_DataWrite(unsigned char dataByte)
{
 LCD_SendHigherNibble(dataByte);
 LCD_SendDataSignals();
 dataByte=dataByte<<4;
 LCD_SendHigherNibble(dataByte);
 LCD_SendDataSignals();
}
void LCD_Reset(void)
{
 LCD_SendHigherNibble(0x30);
 LCD_SendCmdSignals();
 delay_ms(100);
 LCD_SendHigherNibble(0x30);
 LCD_SendCmdSignals();
 delay_us(200);
 LCD_SendHigherNibble(0x30);
 LCD_SendCmdSignals();
 delay_us(200);
 LCD_SendHigherNibble(0x20);
 LCD_SendCmdSignals();
 delay_us(200);
}
void LCD_Init(void)
{
 delay_ms(100);
 LCD_Reset();
 LCD_CmdWrite(0x28u);
 LCD_CmdWrite(0xE0u);
 LCD_CmdWrite(0x01u);
 LCD_CmdWrite(0x80u);
}
void LCD_DisplayString(const char *ptr_string)
{
 while((*ptr_string)!='\0')
  LCD_DataWrite(*ptr_string++);
}
int main()
{
 SystemInit();
 IO0DIR|=1U<<31|0x00FF0000;
 IO1DIR|=1U<<25;
 LED_ON;delay_ms(500);LED_OFF;delay_ms(500);
 LCD_Reset();
 LCD_Init();
 delay_ms(500);
 LCD_CmdWrite(0x80);LCD_DisplayString("RV COLLEGE OF ENGG");
 LCD_CmdWrite(0xC0);LCD_DisplayString("COMPUTER SCIENCE");
 LCD_CmdWrite(0x94);LCD_DisplayString("4th SEMESTER");
 LCD_CmdWrite(0xD4);LCD_DisplayString("B SECTION");
 while(1);
}
