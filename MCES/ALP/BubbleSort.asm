;This code performs bubble sort on the given set of integers.
;This code takes 10 input integers.
	AREA RESET, CODE
	ENTRY
	LDR R0,=ARRAY       ;Input array
	LDMIA R0, {R1-R10}  ;Copy from flash memory to SRAM using registers
	MOV SP, #0X40000000
	STMIA SP, {R1-R10}  
	MOV R10, #0X40000000   ; Starting memory adress
	MOV R1, #0
	MOV R11,#0
	MOV R3, R10
LOOP1
	MOV R2, #0
	MOV R4, R10
LOOP2
	CMP R2, #9     ;N-1, here N=10
	BEQ OUTER
	ADD R2, #1
	LDR R0, [R4]
	LDR R5, [R4, #4]
	ADD R4,#4
	CMP R0, R5
	BLT LOOP2
	MOV R6, R0   ;SWAP
	MOV R0, R5
	MOV R5, R6
	ADD R11,#1  ;No of swaps
	STR R5, [R4]
	SUB R4, #4
	STR R0, [R4]
	ADD R4, #4
	B LOOP2
OUTER
	ADD R1, #1
	CMP R1, #10 ;N
	BNE LOOP1
STOP B STOP
ARRAY DCD 11,52,13,42,16,21,33,44,29,30  ;Input Array
	END
