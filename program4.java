import javax.lang.model.util.ElementScanner14;

class program4
{
    public static void main(String args[])
    {
        DoublyCL obj = new DoublyCL();

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
    node prev;
}
class DoublyCL
{
    public node first;
    public node last;
    public int size;

    public DoublyCL()
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
        newn.prev=null;

        if(first==null && last==null)
        {
            first=newn;
            last=newn;
        }
        else
        {
            newn.next=first;
            first.prev=newn;
            first=newn;
        }
        first.prev=last;
        last.next=first;

        this.size++;
    }
    public void Display()
    {
        node temp=first;

        do
        {
            System.out.print("|"+temp.data+"|->");
            temp=temp.next;
        } while(temp!=last.next);
        System.out.println("null");
    }
    public int Count()
    {
        return size;
    }
    public void InsertLast(int no)
    {
        node newn=null;

        newn=new node();

        newn.data=no;
        newn.next=null;
        newn.prev=null;

        if(first==null && last==null)
        {
            first=newn;
            last=newn;
        }
        else
        {
           newn.prev=last;
           last.next=newn;
           last=newn;
        }
        first.prev=last;
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
            newn.prev=null;

            for(int i=1;i<pos-1;i++)
            {
                temp=temp.next;
            }
            newn.prev=temp;
            newn.next=temp.next;
            temp.next.prev=newn;
            temp.next=newn;

            this.size++;
        }
    }
    public void DeleteFirst()
    {
        if(first==null && last==null)
        {
            return;
        }
        else if(first==last)
        {
            first=null;
            last=null;
        }
        else
        {
            first=first.next;
            last.next=first;
            first.prev=last;
        }
        this.size--;
    }
    public void DeleteLast()
    {
        if(first==null && last==null)
        {
            return;
        }
        else if(first==last)
        {
            first=null;
            last=null;
        }
        else
        {
            last=last.prev;
            last.next=first;
            first.prev=last;
        }
        this.size--;
    }
    public void DeleteAtPos(int ipos)
    {
        if((ipos < 1) || (ipos > size))
        {
            return;
        }
        if(ipos ==1)
        {
          DeleteFirst();
        }
        else if(ipos == size)
        {
         DeleteLast();
        }
        else
        {
          node temp = first;
        
          for(int i = 1; i < ipos -1 ; i ++)
          {
             temp = temp.next;
          }
       
         temp.next = temp.next.next;
         temp.next.prev = temp;
        
        size--;
        }
    }
}