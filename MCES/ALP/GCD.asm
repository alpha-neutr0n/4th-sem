;This code computes GCD of two numbers
;The numbers are M and N respectively
	AREA	RESET, CODE
		ENTRY
		LDR R0,=N
		LDR R1,[R0]
		LDR R0,=M
		LDR R2,[R0]
		
GCD
		CMP R1,R2
		BEQ EXIT
		BGT LBL
		SUB R2,R1
		B GCD
LBL 
		SUB R1,R2
		B GCD

EXIT
		MOV R0,#0X40000000
		STR R1,[R0]
STOP	B STOP

N DCD &6
M DCD &3
		END
