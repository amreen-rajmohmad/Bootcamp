public class MaxHeap {

    private static int maxsize;
    private  static int size=0;
    private  static int[] heap;


    private MaxHeap(int maxsize)
    {
        MaxHeap.maxsize = maxsize;
        MaxHeap.heap = new int[maxsize];
        MaxHeap.heap[0] = Integer.MAX_VALUE;

        for (int i=1;i<MaxHeap.heap.length;i++)
        {
            MaxHeap.heap[i]=-1;
        }

    }

    private static void insert(int x)
    {

        if(MaxHeap.heap[0]==Integer.MAX_VALUE)
        {
            MaxHeap.size++;
            MaxHeap.heap[0] =x;
            MaxHeap.heap[1] = -1;
            MaxHeap.heap[2] = -1;
            System.out.println(x+" is inserted at position 0");
            maxsize =size;
        }
        else
        {
            int v = size/2;
            int parent;
            if(v==0 || v==1)
            {
                parent =0;
            }
            else
            {
                parent = v-1;
            }
            int left =  parent*2 +1;
            int right = parent * 2 +2;

            if(MaxHeap.heap[left]==-1)
            {
                MaxHeap.heap[left]=x;
                System.out.println(x+" is inserted at position "+ left);
                size++;
            }
            else if(MaxHeap.heap[right] == -1)
            {
                MaxHeap.heap[right] = x;
                System.out.println(x+" is inserted at position "+ right);
                size++;
            }
            else
            {
                MaxHeap.heap[size] = x;
                System.out.println(x+" is inserted at position "+ size);
                size++;

            }

        }
        System.out.println("size is " + MaxHeap.size);

        heapify(MaxHeap.size,x);

    }

    private static void swap(int a, int b)
    {
        int temp = MaxHeap.heap[a];
        MaxHeap.heap[a]=MaxHeap.heap[b];
        MaxHeap.heap[b] =temp;
    }

    private static void heapify(int c, int x)
    {
        if(c==0 || c==1)
        {
            System.out.println("found at position 0");

            return;
        }

        int parent = c /2 -1;
        int left = parent *2 +1;
        int right = parent *2 +2;
        if(MaxHeap.heap[left]<= MaxHeap.heap[parent] && MaxHeap.heap[right]<= MaxHeap.heap[parent])
        {
            if(MaxHeap.heap[left]==x)
            {
                System.out.println("found at position "+left);
            }
            else
            {
                System.out.println("found at position "+ right);
            }
            return;
        }
        if(MaxHeap.heap[left]> MaxHeap.heap[parent])
        {
            swap(left, parent);
        }
        if(MaxHeap.heap[right]>MaxHeap.heap[parent])
        {
            swap(right,parent);
        }

        heapify(parent+1,x);

    }

    private static void fix(int p)
    {
        int l = 2*p+1;
        int r = 2*p+2;
        if(MaxHeap.heap[p]==-1)
        {
            return;
        }
        if(MaxHeap.heap[p]< MaxHeap.heap[l])
        {
            swap(p,l);
        }
        if(MaxHeap.heap[p]<MaxHeap.heap[r])
        {
            swap(p,r);
        }
        fix(l);
        fix(r);

    }

    private static void popmax()
    {
        int max = MaxHeap.heap[0];
        MaxHeap.heap[0]= MaxHeap.heap[MaxHeap.size-1];
        MaxHeap.heap[MaxHeap.size-1]=-1;
        MaxHeap.size--;
        fix(0);

        System.out.println("max element is " +max);
    }

    public static void main(String[] args) {
        MaxHeap a = new MaxHeap(20);
        a.insert(4);
        a.insert(20);
        a.insert(5);
        a.insert(3);
        a.insert(2);
        a.insert(7);
        a.insert(10);
        a.insert(90);

        for ( int i=0;i<MaxHeap.heap.length;i++)
        {
            System.out.println(MaxHeap.heap[i]);


        }
        popmax();
        for ( int i=0;i<MaxHeap.heap.length;i++)
        {
            System.out.println(MaxHeap.heap[i]);


        }

    }
}
