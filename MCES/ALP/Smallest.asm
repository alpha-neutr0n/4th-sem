;THIS CODE COMPUTES THE SMALLEST OF THE GIVEN NUMBERS
;THE FINAL OUTPUT IS STORED IN 'R2'
;R5 HOLDS THE NUMBER OF VALUES
	AREA RESET, CODE
		ENTRY
		LDR R0,=NUMS
		LDR R1,[R0]
		MOV R2,R1
CONT
		ADD R0,#4
		LDR R3,[R0]
		SUBS R4,R2,R3
		MOVCS R2,R3
		ADD R5,#1
		CMP R5,#5
		BNE CONT
STOP B STOP
NUMS DCD &5,&9,&4,&8,&3
		END
