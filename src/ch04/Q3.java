package ch04;

public class Q3 {

    private int max;
    private int ptrA;
    private int ptrB;
    private int[] stk;

    public enum AorB {
        StackA, StackB
    };
    // 실행할 때 예외：스택이 비어 있음
    public class EmptyIntStackX2Exception extends RuntimeException {
        public EmptyIntStackX2Exception() {
        }
    }

    // 실행할 때 예외：스택이 가득 참
    public class OverflowIntStackX2Exception extends RuntimeException {
        public OverflowIntStackX2Exception() {
        }
    }

    public Q3(int capacity) {
        ptrA = 0;
        ptrB = capacity - 1;
        max = capacity;
        try {
            stk = new int[max]; // 스택 본체용 배열을 생성
        } catch (OutOfMemoryError e) { // 생성할 수 없습니다.
            max = 0;
        }
    }


    public int push(AorB sw, int x) throws OverflowIntStackX2Exception {
        if (ptrA >= ptrB + 1) // 스택이 가득 참
            throw new OverflowIntStackX2Exception();
        switch (sw) {
            case StackA:
                stk[ptrA++] = x;
                break;
            case StackB:
                stk[ptrB--] = x;
                break;
        }
        return x;
    }

    public int pop(AorB sw) throws EmptyIntStackX2Exception {
        int x = 0;
        switch (sw) {
            case StackA:
                if (ptrA <= 0) // 스택 A가 비어 있음
                    throw new EmptyIntStackX2Exception();
                x = stk[--ptrA];
                break;
            case StackB:
                if (ptrB >= max - 1) // 스택 B가 비어 있음
                    throw new EmptyIntStackX2Exception();
                x = stk[++ptrB];
                break;
        }
        return x;
    }

    public int peek(AorB sw) throws EmptyIntStackX2Exception {
        int x = 0;
        switch (sw) {
            case StackA:
                if (ptrA <= 0) // 스택 A가 비어 있음
                    throw new EmptyIntStackX2Exception();
                x = stk[ptrA - 1];
                break;
            case StackB:
                if (ptrB >= max - 1) // 스택 B가 비어 있음
                    throw new EmptyIntStackX2Exception();
                x = stk[ptrB + 1];
                break;
        }
        return x;
    }

    public int indexOf(AorB sw, int x) {
        switch (sw) {
            case StackA:
                for (int i = ptrA - 1; i >= 0; i--) // 꼭대기쪽부터 선형 검색
                    if (stk[i] == x)
                        return i; // 검색성공
                break;
            case StackB:
                for (int i = ptrB + 1; i < max; i++) // 꼭대기쪽부터 선형 검색
                    if (stk[i] == x)
                        return i; // 검색성공
                break;
        }
        return -1; // 검색실패
    }

    public void clear(AorB sw) {
        switch (sw) {
            case StackA:
                ptrA = 0;
                break;
            case StackB:
                ptrB = max - 1;
                break;
        }
    }

    public int capacity() {
        return max;
    }

    public int size(AorB sw) {
        switch (sw) {
            case StackA:
                return ptrA;
            case StackB:
                return max - ptrB - 1;
        }
        return 0;
    }

    public boolean isEmpty(AorB sw) {
        switch (sw) {
            case StackA:
                return ptrA <= 0;
            case StackB:
                return ptrB >= max - 1;
        }
        return true;
    }

    public boolean isFull() {
        return ptrA >= ptrB + 1;
    }

    public void dump(AorB sw) {
        switch (sw) {
            case StackA:
                if (ptrA <= 0)
                    System.out.println("스택이 비었습니다.");
                else {
                    for (int i = 0; i < ptrA; i++)
                        System.out.print(stk[i] + " ");
                    System.out.println();
                }
                break;
            case StackB:
                if (ptrB >= max - 1)
                    System.out.println("스택이 비었습니다.");
                else {
                    for (int i = max - 1; i > ptrB; i--)
                        System.out.print(stk[i] + " ");
                    System.out.println();
                }
                break;
        }
    }
}
