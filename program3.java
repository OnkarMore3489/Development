import javax.lang.model.util.ElementScanner14;

class program3
{
    public static void main(String args[])
    {
        SinglyCL obj = new SinglyCL();

        obj.InsertFirst(51);
        obj.InsertFirst(21);
        obj.InsertFirst(11);

         obj.InsertLast(101);

         obj.InsertAtPos(75,3);

         obj.DeleteFirst();
         obj.DeleteLast();
         obj.DeleteAtPos(2);

        obj.Display();
        System.out.println("Number of Elements are : "+obj.Count());
    }
}
class node
{
    int data;
    node next;
}
class SinglyCL
{
    public node first;
    public node last;
    public int size;

    public SinglyCL()
    {
        this.first=null;
        this.last=null;
        this.size=0;
    }
    public void InsertFirst(int no)
    {
        node newn=null;

        newn=new node();

        newn.data=no;
        newn.next=null;

        if(first==null && last==null)
        {
            first=newn;
            last=newn;
        }
        else
        {
            newn.next=first;
            first=newn;
        }
        last.next=first;

        this.size++;
    }
    public void InsertLast(int no)
    {
        node newn=null;

        newn=new node();

        newn.data=no;
        newn.next=null;

        if(first==null && last==null)
        {
            first=newn;
        }
        else
        {
            last.next=newn;
            last=newn;
        }
        last.next=first;

        this.size++;
    }
    public void InsertAtPos(int no,int pos)
    {
        if(pos < 1 || pos > size+1)
        {
            return;
        }

        if(pos==1)
        {
            InsertFirst(no);
        }
        else if(pos==size+1)
        {
            InsertLast(no);
        }
        else
        {
            node newn=new node();
            node temp=first;

            newn.data=no;
            newn.next=null;

            for(int i=1;i<pos-1;i++)
            {
                temp=temp.next;
            }
            newn.next=temp.next;
            temp.next=newn;

            this.size++;
        }
    }
    public void DeleteLast()
    {
        if(first==null && last==null)
        {
            return;
        }

        if(first==last)
        {
            first=null;
            last=null;
        }
        else
        {
            node temp=first;

            while(temp.next!=last)
            {
                temp=temp.next;
            }
            temp.next=null;
            last=temp;
            last.next=first;
        }

        this.size--;
    }
    public void DeleteFirst()
    {
        
        if(first==null && last==null)
        {
            return;
        }

        if(first==last)
        {
            first=null;
            last=null;
        }
        else
        {
            first=first.next;
            last.next=first;
        }
        this.size--;
    }
    public void DeleteAtPos(int pos)
    {
		if((pos < 1) || (pos > size))
		{
			return;
		}

		if(pos == 1)
		{
			DeleteFirst();
		}
		else if(pos == size)
		{
			DeleteLast();
		}
		else
		{
			node temp = first;

			for(int i =1; i < pos-1; i++)
			{
				temp = temp.next;
			}

			temp.next = temp.next.next;
            last.next=first;
			this.size--;
		}
    }
    public void Display()
    {
        node temp=first;
        if(first==null && last==null)
        {
            return;
        }

        do
        {
            System.out.print("|"+temp.data+"|->");
            temp=temp.next;
        }while(temp!=last.next);
    }
    public int Count()
    {
        return size;
    }
}
