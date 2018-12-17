public class MyLinkedList{
  class Node{
   private Integer data;
   private Node next,prev;

   public Node(Integer data0, Node prev0, Node next0){
      data=data0;
      next=next0;
      prev=prev0;
    }
   public Node next(){
      return next;
    }
   public Node prev(){
      return prev;
    }
   public void setNext(Node other){
      next=other;
    }
   public void setPrev(Node other){
      prev=other;
    }
   public Integer getData(){
      return data;
    }
   public Integer setData(Integer i){
      return data;
    }
   public String toString(){
      return "" + data;
    }}
  private int size;
  private Node start,end;
  private Node nthNode(int i){
    Node current=start;
    for(int j=0;j<i;j++){
      current=current.next;
    }
    return current;
  }
  public MyLinkedList(){
    size=0;
  }
  public int size(){
    return size;
  }
  public Boolean add(int value){
    if (size==0){
      Node current=new Node(value,null,null);
      start=current;end=current;
      size+=1;
      return true;
    }
    Node current = new Node(value,end,null);
    end.setNext(current);
    end=current;
    size+=1;
    return true;
  }
  public String toString(){
    String s ="[";
    Node current=start;
    while(!(current==null)){
      s+=current.toString();
      current=current.next();
      if(!(current==null))s+=", ";
    }
    s+="]";
    return s;
  }
  public Integer get(int index){
    if (index>=size||index<0)throw new IndexOutOfBoundsException();
    Node current=nthNode(index);
    return current.getData();
  }
  public Integer set(int index,Integer value){
    if (index>=size||index<0)throw new IndexOutOfBoundsException();
    Node current=nthNode(index);
    int ret=current.getData();
    current.setData(value);
    return ret;
  }
  public Boolean contains(Integer value){
    Node current=start;
    while(!(current==null)){
      if(current.getData()==value)return true;
      current=current.next;
    }
    return false;
  }
  public int indexOf(Integer value){
    Node current=start;
    int i=0;
    while(!(current==null)){
      if(current.getData().intValue()==value.intValue())return i;
      i++;
      current=current.next();
      }
    return -1;
    }
  public void add(int index, Integer value){
    if (index>size||index<0)throw new IndexOutOfBoundsException();
    size+=1;
    Node current=nthNode(index);
    if(current==null){add(value.intValue());return;}
    Node New=new Node(value,current.prev(),current);
    if(!(current.prev()==null))current.prev().setNext(New);
    else start=New;
    current.setPrev(New);
  }
  public Integer remove(int index){
    if (index>=size||index<0)throw new IndexOutOfBoundsException();
    Node current=nthNode(index);
    int ret=current.getData();
    Node before=current.prev();
    Node after=current.next();
    if(!(before==null))before.setNext(after);
    else start=after;
    if(!(after==null))after.setPrev(before);
    else end=before;
    size-=1;
    return ret;
  }
  public Integer removes(int index){
    if (index>=size)throw new IndexOutOfBoundsException();
    Node current=nthNode(index);
    int ret=current.getData();
    Node before=current.prev();
    Node after=current.next();
    if(!(before==null))before.setNext(after);
    else start=after;
    if(!(after==null))after.setPrev(before);
    else end=before;
    size-=1;
    return ret;
  }
  public Boolean remove(Integer value){
    if(indexOf(value)==-1){return  false;}
    this.removes(indexOf(value));
    return true;
  }
}
