import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;


public class Steams1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
//		@Test
		public void regular() {
			
		ArrayList<String> names=new ArrayList<String>();
		names.add("Abhijit");
		names.add("Rohit");
		names.add("Adnan");
		names.add("Ram");
		names.add("Ayush");
		int count=0;
		for(int i=0;i<names.size();i++) {
			
			if(names.get(i).startsWith("A")) {
				count++;
			}
		}
		System.out.println(count);
	}
	
//		@Test
	 public void steamFilter() {
			ArrayList<String> names=new ArrayList<String>();
			names.add("Abhijit");
			names.add("Rohit");
			names.add("Adnan");
			names.add("Ram");
			names.add("Ayush");
			
			long c=names.stream().filter(s->s.startsWith("A")).count();
			System.out.println(c);
			
	//Another way
			long d=Stream.of("Abhijit","Rohit","Adnan","Ram","Ayush").filter(s->s.startsWith("A")).count();
			System.out.println(d);
			
//			names.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));
			names.stream().filter(s->s.length()>4).limit(1).forEach(s->System.out.println(s));
			
	 }
//		@Test
	public void streamMap() {
			Stream.of("Abhijit","Rohit","Adnan","Rama","Ayusha").filter(s->s.endsWith("a")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
			
			String[] names= {"Axbhijit","Rohit","Adnan","Rama","Ayusha"};
			List<String> upNames=Arrays.asList(names);
			upNames.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
			
	}
//	@Test
	public void streamConcat() {
		ArrayList<String> names=new ArrayList<String>();
		names.add("Abhijit");
		names.add("Rohit");
		names.add("Adnan");
		names.add("Ram");
		names.add("Ayush");
		
		String[] names1= {"Saniya","Soumen","Soham","Animesh","Faiz"};
		List<String> names2=Arrays.asList(names1);
		
		Stream<String> n1= Stream.concat(names.stream(), names2.stream());
//		n1.sorted().forEach(s->System.out.println(s));
		
		boolean flag=n1.anyMatch(s->s.equalsIgnoreCase("Adnan"));
		System.out.println(flag);
		Assert.assertTrue(flag);
		
	}
	@Test
	public void streamCollect() {
		List<String> ls=Stream.of("Abhijit","Rohit","Adnan","Rama","Ayusha").filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).collect(Collectors.toList());
		System.out.println(ls.get(0));
		
		List<Integer> li=Arrays.asList(3,2,2,4,4,5,4,3,2,6,6,7,5,8,7,9);
		List<Integer> li2=li.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(li2.get(2));
	}

}

