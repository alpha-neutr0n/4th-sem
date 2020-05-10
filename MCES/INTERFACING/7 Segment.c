#include<lpc214x.h>
#include<string.h>
#define LED_OFF (IO0SET = 1U<<31)
#define LED_ON (IO0CLR = 1U<<31)
#define PLOCK 0x00000400
void delay_ms(unsigned int j);
void SystemInit(void);
unsigned char getAlphaCOde(unsigned char alphachar);
void SEG(char *buf);
int main()
{
 IO0DIR|=1U<<31|1U<<19|1U<<20|1U<<30;
 LED_ON;
 SystemInit();
  while(1)
  {
   SEG(" fire help ");
   delay_ms(500);
  //SEG("cs");
 // delay_ms(500);
  }
}
unsigned char getAlphaCode(unsigned char alphachar)
{
 switch(alphachar)
 {
  case 'f':return 0x8e;
  case 'i':return 0xf9;
  case 'r':return 0xce;
  case 'v':return 0xc1;
  case 'c':return 0xc6;
  case 's':return 0x92;
  case 'e':return 0x86;
  case 'h':return 0x89;
  case 'l':return 0xc7;
  case 'p':return 0x8c;
  case ' ':return 0xff;
  default:break;
 }
return 0xff;
}
void SEG(char *buf)
{
unsigned char i,j;
unsigned char segment,temp=0;
for(i=0;i<strlen(buf);i++)
{
 segment=getAlphaCode(*(buf+i));
  for(j=0;j<8;j++)
  {
   temp=segment &0x80;
   if(temp==0x80)
    IOSET0|=1<<19;
   else
    IOCLR0|=1<<19;
   
   IOSET0|=1<<20;
   delay_ms(1);
   IOCLR0|=1<<20;
   segment=segment<<1;
}
   delay_ms(500);
  IOSET0|=1<<30;
   delay_ms(1);
   IOCLR0|=1<<30;

 }
   
   IOSET0|=1<<30;
   delay_ms(1);
   IOCLR0|=1<<30;
   return;
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
 VPBDIV=0X01;
 }
void delay_ms(unsigned int j)
{
 unsigned int x,i;
 for(i=0;i<j;i++)
 {
 for(x=0;x<10000;x++);
 }
}
