package com.prac.pattern.creational;

/**
 * Too many constructor arguments.
 * Incorrect object state.
 * 
 * @author sudhendu.kumar
 *
 */
public class UserBuilderMain{
	
	public static void main(String[] args) {
		User user1 = new User.UserBuilder("Lokesh", "Gupta")
			    .age(30)
			    .phone("1234567")
			    .address("Fake address 1234")
			    .build();
			 
			    System.out.println(user1);
			 
			    User user2 = new User.UserBuilder("Jack", "Reacher")
			    .age(40)
			    .phone("5655")
			    //no address
			    .build();
			 
			    System.out.println(user2);
			 
			    User user3 = new User.UserBuilder("Super", "Man")
			    //No age
			    //No phone
			    //no address
			    .build();
			 
			    System.out.println(user3);
			    
			    BankAccountBuilder account = new BankAccountBuilder.Builder(1234L)
			            .withOwner("Marge")
			            .atBranch("Springfield")
			            .openingBalance(100)
			            .atRate(2.5)
			            .build();
			    System.out.println(account);
	}
}

class User {
    //All final attributes
    private final String firstName; // required
    private final String lastName; // required
    private final int age; // optional
    private final String phone; // optional
    private final String address; // optional

    User(UserBuilder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.phone = builder.phone;
        this.address = builder.address;
    }

    //All getter, and NO setter to provde immutability
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "User: " + this.firstName + ", " + this.lastName + ", " + this.age + ", " + this.phone + ", " + this.address;
    }
    // inner class
    static class UserBuilder
    {
        public final String firstName;
        public final String lastName;
        public int age;
        public String phone;
        public String address;

        public UserBuilder(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }
        public UserBuilder age(int age) {
            this.age = age;
            return this;
        }
        public UserBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }
        public UserBuilder address(String address) {
            this.address = address;
            return this;
        }
        //Return the finally consrcuted User object
        public User build() {
            User user =  new User(this);
            validateUserObject(user);
            return user;
        }
        private void validateUserObject(User user) {
            //Do some basic validations to check
            //if user object does not break any assumption of system
        }
    }


}