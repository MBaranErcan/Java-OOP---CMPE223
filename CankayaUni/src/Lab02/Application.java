package Lab02;
public class Application {
    public static void main(String[] args) {
        IntSet set1 = new ArrayBasedSet();
	set1.add(33);
	set1.add(23);
	set1.add(14);
	set1.add(1);
	set1.add(2);
	set1.add(23);
	set1.add(18);
	set1.add(33);
	set1.add(33);
	set1.add(33);
	System.out.println(set1); //set1.toString is invoked automatically
	if(set1.contains(44))
            System.out.println("Set1 contains 44");
	else
            System.out.println("Set1 doesn’ttcontain 44");
	set1.remove(23);
	System.out.println(set1);
	int []items=set1.toArray();
        for(int a:items)
            System.out.println(a);	

        IntSet set2 = new ArrayBasedSet();
                set1.add(221);
                set1.add(23);
                set1.add(104);
                set1.add(1);
        set2=set2.union(set1);
        System.out.println(set2);
        IntSet set3=set2.intersection(set1);
        System.out.println(set3);
        IntSet set4=set2.difference(set1);
        System.out.println(set4);

    }
}
