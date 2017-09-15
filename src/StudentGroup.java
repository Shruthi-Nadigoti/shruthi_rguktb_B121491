import java.util.Date;

/**
 * A fix-sized array of students
 * array length should always be equal to the number of stored elements
 * after the element was removed the size of the array should be equal to the number of stored elements
 * after the element was added the size of the array should be equal to the number of stored elements
 * null elements are not allowed to be stored in the array
 * 
 * You may add new methods, fields to this class, but DO NOT RENAME any given class, interface or method
 * DO NOT PUT any classes into packages
 *
 */
public class StudentGroup implements StudentArrayOperation {

	private Student[] students;
	
	/**
	 * DO NOT remove or change this constructor, it will be used during task check
	 * @param length
	 */
	public StudentGroup(int length) {
		this.students = new Student[length];
	}

	@Override
	public Student[] getStudents() {
		// Add your implementation here
		return students;
	}

	@Override
	public void setStudents(Student[] students) throws  IllegalArgumentException{
		// Add your implementation here
		if(students==null)
			throw new IllegalArgumentException();
		else
			this.students=students;
	}

	@Override
	public Student getStudent(int index)throws  IllegalArgumentException {
		// Add your implementation here
		if(index<0||index>=students.length)
		     throw new IllegalArgumentException();
		 return students[index];
			
	}

	@Override
	public void setStudent(Student student, int index)throws  IllegalArgumentException{
		// Add your implementation here
		if(index<0||index>=students.length)
		     throw new IllegalArgumentException();
		 this.students[index]=student;
	}

	@Override
	public void addFirst(Student student) throws  IllegalArgumentException{
		// Add your implementation here
		  if(student==null)
		  	throw new IllegalArgumentException();
		  else{
			    Student[] newarr=new Student[this.students.length+1];
			    newarr[0]=student;
			    for(int i=1;i<=students.length;i++)
				newarr[i]=students[i-1];
			    students=newarr;
			}
	}

	@Override
	public void addLast(Student student) throws  IllegalArgumentException{
		// Add your implementation here
		if(student==null)
		    	throw new IllegalArgumentException();
	       Student[] newarr=new Student[students.length+1];
		    for(int i=0;i<students.length;i++)
		        newarr[i]=students[i];
		 newarr[students.length]=student;
		 students=newarr;
	}

	@Override
	public void add(Student student, int index)throws  IllegalArgumentException{
		// Add your implementation here
		if(student==null || index<0||index>=students.length)
		    throw new IllegalArgumentException();
		Student[] newarr=new Student[students.length+1];
		for(int i=0;i<index;i++)
		        newarr[i]=students[i];
		newarr[index]=student;
		for(int i=index;i<students.length;i++)
		       newarr[i+1]=students[i];
		students=newarr;
	}

	@Override
	public void remove(int index) throws  IllegalArgumentException{
		// Add your implementation here
		if(index<0||index>=students.length)
		     throw new IllegalArgumentException();
		int size=students.length;
		Student[] arr=new Student[size-1];
		for(int i=0;i<index;i++)
		     arr[i]=students[i];
		for(int i=index;i<size-1;i++)
		     arr[i]=students[i+1];
	        students=arr;
	}

	@Override
	public void remove(Student student)throws  IllegalArgumentException{
		// Add your implementation here
		int index=-1;
		if(student==null)
		    throw new IllegalArgumentException();
		int size=students.length;
		for(int i=0;i<size;i++)
		    if(students[i].equals(student))
		          index=i;
		if(index!=-1)
		{
		        Student[] a=new Student[size-1];
		        for(int i=0;i<index;i++)
		            a[i]=students[i];
		       for(int i=index;i<size-1;i++)
		            a[i]=students[i+1];
		       students=a;
		}
		   
	}

	@Override
	public void removeFromIndex(int index)throws  IllegalArgumentException{
		// Add your implementation here
		if(index<0||index>=students.length)
		     throw new IllegalArgumentException();
		Student[] newarr=new Student[index+1];
		for(int i=0;i<index;i++)
		     newarr[i]=students[i];
		students=newarr;
	}

	@Override
	public void removeFromElement(Student student)throws  IllegalArgumentException{
		// Add your implementation here
		int index=-1;
		if(student==null)
		    throw new IllegalArgumentException();
		int size=students.length;
		for(int i=0;i<size;i++)
		if(students[i].equals(student))
		      index=i;
	        if(index!=-1)
		       removeFromIndex(index);
		return;
	}

	@Override
	public void removeToIndex(int index)throws  IllegalArgumentException{
		// Add your implementation here
		int j=0;
		if(index<0||index>=students.length)
		     throw new IllegalArgumentException();
	        Student[] a=new Student[students.length-index];
		for(int i=index;i<students.length;i++)
		     a[j++]=students[i];
		students=a;
	}

	@Override
	public void removeToElement(Student student)throws  IllegalArgumentException{
		// Add your implementation here
		int index=-1;
		if(student==null)
		    throw new IllegalArgumentException();
		int n=students.length;
		for(int i=0;i<n;i++)
		    if(students[i].equals(student))
		          index=i;
		    if(index!=-1)
		       removeToIndex(index);
		    
	}

	@Override
	public void bubbleSort() {
		// Add your implementation here
		for (int i=0; i<students.length; i++) {
			for (int j=0;j<students.length-i-1 ; j++){
				if(students[j].compareTo(students[j+1])>0){
					Student temp=students[j];
					students[j]=students[j+1];
					students[j+1]=temp;
				}
			}
		}
	}

	@Override
	public Student[] getByBirthDate(Date date)throws  IllegalArgumentException{
		// Add your implementation here
		/*int count=0;
		if(date==null)
			throw new IllegalArgumentException();
		for(int i=0; i< students.length;i++)
		{
			if((students[i]. birthDate).compareTo(date)<=0){
				count++;
			}
		}
		int Student[] newarr=new Student[count];
		int j=0;
		for(int i=0; i< students.length;i++)
		{
			if((students[i]. birthDate).compareTo(date)<=0){
				newarr[j++]=students[i];
			}
		}
		return newarr;*/
		return null;
	}

	@Override
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) {
		// Add your implementation here
		/*
		int count=0;
		if(firstDate==null || lastDate==null)
			return IllegalArgumentException();
		else
			{
				for(int i=0; i< students.length;i++)
				{
					if((students[i]. birthDate).compareTo(firstDate)>0&&students[i]. birthDate).compareTo(lastDate)<0){
						count++;
					}
				}
			}
		int Students[] newarr=new Student[count];
		int j=0;
		for(int i=0; i< students.length;i++)
		{
			if((students[i]. birthDate).compareTo(firstDate)>0&&(students[i]. birthDate).compareTo(lastDate)<0){
				newarr[j++]=students[i];
			}
		}
		return newarr;
		*/
		
		return null;
	}

	@Override
	public Student[] getNearBirthDate(Date date, int days) {
		// Add your implementation here
		return null;
	}

	@Override
	public int getCurrentAgeByDate(int indexOfStudent) {
		// Add your implementation here
		/*
		if(indexOfStudent<0 || indexOfStudent >= students.length)
		{
			throw IllegalArgumentException();
		}
		
		LocalDate birthdate = new LocalDate (students[indexOfStudent].birthDate.getYear(),students[indexOfStudent].birthDate.getMonth(),students[indexOfStudent].birthDate.getDate());
		LocalDate now = new LocalDate();
		Years age = Years.yearsBetween(birthdate, now);
		return age.getYears();
		*/
		return 0;
	}

	@Override
	public Student[] getStudentsByAge(int age) {
		// Add your implementation here
		int count=0;
		LocalDate now = new LocalDate();
		for(int i=0; i< students.length;i++)
		{
			LocalDate birthdate = new LocalDate (students[i].getBirthDate().getYear(),students[i].getBirthDate().getMonth(),student[i].getBirthDate().getDate());
			Years a = Years.yearsBetween(birthdate, now);
			if(a.getYears()==age){
				count++;
			}
		}
		int Student[] newarr=new Student[count];
		int j=0;
		for(int i=0; i< students.length;i++)
		{
			LocalDate birthdate = new LocalDate (students[i].getBirthDate().getYear(),students[i].getBirthDate().getMonth(),student[i].getBirthDate().getDate());
			Years a = Years.yearsBetween(birthdate, now);
			if(a.getYears()==age){
				newarr[j++]=students[i];
			}
		}
		return newarr;
		//return null;
	}

	@Override
	public Student[] getStudentsWithMaxAvgMark() {
		// Add your implementation here
		double max=students[0].getAvgMark();
		int n=students.length;
		for(int i=0; i < n ;i++)
		{
			if(students[i].getAvgMark() > max)
				max=students[i].getAvgMark();
		}
		int count=0;
		for(int i=0;i< n;i++)
		{
			if(max==students[i].getAvgMark())
				count++;
		}
		Student newarr[]=new Student[count];
		int j=0;
		for(int i=0;i< n;i++)
		{
			if(students[i].getAvgMark()==max)
				newarr[j++]=students[i];
		}
		return newarr;
		
	}

	@Override
	public Student getNextStudent(Student student) throws IllegalArgumentException {
		if(student==null)
		    throw new IllegalArgumentException();
		for(int i=0;i<students.length;i++)
		    if(students[i]==student)
		        return students[i+1];
		return null;
	}
}
