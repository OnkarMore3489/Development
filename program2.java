import javax.lang.model.util.ElementScanner14;

class program2
{
    public static void main(String args[])
    {
        DoublyLL obj = new DoublyLL();

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
class DoublyLL
{
    private node first;
    private int size;

    public DoublyLL()
    {
        this.first=null;
        this.size=0;
    }
    public void InsertFirst(int no)
    {
        node newn=null;
       
        newn=new node();

        newn.data=no;
        newn.next=null;
        newn.prev=null;

        if(first==null)
        {
            first=newn;
        }
        else
        {
            newn.next=first;
            first=newn;
        }
        this.size++;
    }
    public void InsertLast(int no)
    {
        node newn=null;
       
        newn=new node();

        newn.data=no;
        newn.next=null;
        newn.prev=null;

        if(first==null)
        {
            first=newn;
        }
        else
        {
           node temp=first;

           while(temp.next!=null)
           {
               temp=temp.next;
           }
           newn.prev=temp;
           temp.next=newn;
        }
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
            node newn = new node();
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
            temp.next=newn;

            this.size++;
        }
    }
    public void DeleteFirst()
    {
        if(first==null)
        {
            return;
        }

        if(first.next==null)
        {
            first=null;
        }
        else
        {
            first=first.next;
            first.prev=null;
        }
        this.size--;
    }
    public void DeleteLast()
    {
        if(first==null)
        {
            return;
        }

        if(first.next==null)
        {
            first=null;
        }
        else
        {
            node temp=first;

            while(temp.next.next!=null)
            {
                temp=temp.next;
            }
            temp.next=null;
        }
        this.size--;
    }
    public void DeleteAtPos(int pos)
    {
        if(pos < 1 || pos > size)
        {
            return;
        }

        if(pos==1)
        {
            DeleteFirst();
        }
        else if(pos==size)
        {
            DeleteLast();
        }
        else
        {
            node temp=first;

            for(int i=1;i<pos-1;i++)
            {
                temp=temp.next;
            }
            temp.next=temp.next.next;
            temp.next.prev=temp;

            this.size--;
        }
    }
    public void Display()
    {
        node temp=first;

        while(temp!=null)
        {
            System.out.print("|"+temp.data+"|->");
            temp=temp.next;
        }
        System.out.println("null");
    }
    public int Count()
    {
        return (this.size);
    }
}