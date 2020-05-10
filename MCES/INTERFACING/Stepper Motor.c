#include<lpc214x.h>
#define LED_OFF (IO0SET =1U<<31)
#define LED_ON (IO0CLR=1U<<31)
#define PLOCK 0x00000400
void delay(unsigned int j)
{
 unsigned int x,i;
 for(i=0;i<j;i++)
 {
  for(x=0;x<10000;x++);
 }
}
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
}
int main()
{
 unsigned int no_of_steps_clk=100,no_of_steps_aclk=100;
 IO0DIR|=1U<<31|0x00FF0000|1U<<30;
 LED_ON;delay(500);LED_OFF;
 SystemInit();
 do{
  IO0CLR=0x000F0000;IO0SET=0x00010000;delay(10);if(--no_of_steps_clk==0)break;
  IO0CLR=0x000F0000;IO0SET=0x00020000;delay(10);if(--no_of_steps_clk==0)break;
  IO0CLR=0x000F0000;IO0SET=0x00040000;delay(10);if(--no_of_steps_clk==0)break;
  IO0CLR=0x000F0000;IO0SET=0x00080000;delay(10);if(--no_of_steps_clk==0)break;
 }while(1);
 do{
  IO0CLR=0x000F0000;IO0SET=0x00080000;delay(10);if(--no_of_steps_aclk==0)break;
  IO0CLR=0x000F0000;IO0SET=0x00040000;delay(10);if(--no_of_steps_aclk==0)break;
  IO0CLR=0x000F0000;IO0SET=0x00020000;delay(10);if(--no_of_steps_aclk==0)break;
  IO0CLR=0x000F0000;IO0SET=0x00010000;delay(10);if(--no_of_steps_aclk==0)break;
 }while(1);
 IO0CLR=0x00FF0000;
 while(1);
}
