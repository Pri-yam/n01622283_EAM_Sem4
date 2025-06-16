package com.example.demo;

public class Student {
	
	private String studentID;
    private String phone;
    private String dob;
    private Name name;
    private Address address;
    
    // Nested STATIC class for Name
    public static class Name {
    	private String fname;
        private String lname;
    
        public String getFname() {
			return fname;
		}

		public void setFname(String fname) {
			this.fname = fname;
		}

		public String getLname() {
			return lname;
		}

		public void setLname(String lname) {
			this.lname = lname;
		}

        public Name(String fname, String lname) {
            this.fname = fname;
            this.lname = lname;
        }
    }
    
    // Nested STATIC class for Address
    public static class Address {
        private String no;
        private String street;
        private String city;

        public Address(String no, String street, String city) {
            this.no = no;
            this.street = street;
            this.city = city;
        }

        // Getters and setters
        public String getNo() { return no; }
        public void setNo(String no) { this.no = no; }

        public String getStreet() { return street; }
        public void setStreet(String street) { this.street = street; }

        public String getCity() { return city; }
        public void setCity(String city) { this.city = city; }
    }
    
    public Student() {
		
	}

	//Constructor for Student
    public Student(String studentID, String phone, String dob, Name name, Address address) {
        this.studentID = studentID;
        this.phone = phone;
        this.dob = dob;
        this.name = name;
        this.address = address;
    }

    // Getters and setters
    public String getStudentID() { return studentID; }
    public void setStudentID(String studentID) { this.studentID = studentID; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getDob() { return dob; }
    public void setDob(String dob) { this.dob = dob; }

    public Name getName() { return name; }
    public void setName(Name name) { this.name = name; }

    public Address getAddress() { return address; }
    public void setAddress(Address address) { this.address = address; }

	@Override
	public String toString() {
		return "Student [studentID=" + studentID + ", phone=" + phone + ", dob=" + dob + ", name=" + name + ", address="
				+ address + "]";
	}
    
    
}
