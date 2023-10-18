# <h1 align ="center">USER MANAGEMENT SYSTEM</h1>
***
<p align ="center">
<a href="Java url"> 
  <img alt="Java" src="https://img.shields.io/badge/Java->=8-darkblue.svg"/>
</a>
<a href="Maven url"> 
  <img alt="Maven" src="https://img.shields.io/badge/maven-4.0.0-brightgreen.svg"/>
</a>
<a href="Spring Boot url"> 
  <img alt="Spring Boot" src="https://img.shields.io/badge/Spring Boot-3.1.4-brightgreen.svg"/>
</a>
<a href="Spring Boot url"> 
  <img alt="License: MIT" src="https://img.shields.io/badge/License-MIT-yellow.svg"/>
</a>


  
### overview
***
The project "user management system" is a robust SpringBoot Application designed for managing users data efficiently.it provides a set of REST full API endpoints that allows you to perform variose  operations on users 
records,such as adding ,retrieving,updating ,and deteting user information.
### Technologies used
***
* Framework:Spring Boot
* Language:java
* Build Tool:Maven
  ### Controll Flow
  ***
  #### Controller
  The controller  layer is responsible for handling incomming Http request and delegating them to the appropriate Services.
  It defines API  endpoints for thev following operations.
 * Add user: `POST/User`
 * Add Users: `POST/Users`
 * Get All Users: `GET/Users`
 * Get User by ID: `GET/User/{UserId}`
 * Update User by ID: `PUT/update//user/id/{id}/`
 * Update user Name: `PUT/update/id/{id}/username`
 * Delete user by Id: `DELETE/delete/id/{id}`
 ``` java
@RestController

public class UserController {
    @Autowired
    List<User> UserList;
    //addinguser
    @PostMapping("User")
    public String addUser(@RequestBody User newUser)
    {
        UserList.add(newUser);
        return "User Added";
    }
    //get allusers
    @GetMapping("AllUsers")
    public List<User> getAllUser()
    {
        return UserList;
    }
    //update user info
    @PutMapping("update/id/{id}/username")
    public String setusernamebyid(@PathVariable Integer id, @RequestParam String value)
    {
        for(User user:UserList)
        {
            if(user.getUserId().equals(id))
            {
                user.setUserName(value);
                {
                    return  "username:"   + id +  "updated to"  +  value;
                }
            }

        }
        return "invalid user id";
    }
    //updating user information
    @PutMapping("update/user/id/{id}")
    public User updateUser(@RequestParam Integer userId, @RequestBody User updatedUser) {
        User user = userservice.updateUserById(userId, updatedUser);
        if (user == null) {
            // You can throw an exception or handle the "user not found" case here
        }
        return user;
    }
  



    //delete user
      @DeleteMapping("user/id{id}")
    public void deleteUser(@RequestParam Integer userId) {
        userservice.deleteUserById(userId);
    }


}
```
### Repository
The repository level manages data access to the underlying database.
it handles Read,Delete,Update,Create (CRUD) for users .Additionally,it may include data mapping and Conversion between  java objects and database entitties.
```java
@Configuration
public class BeanBag {
    @Bean
    public List<User> getDataSource()
    {
        return new ArrayList<>();
    }
}
```
## Service
``` java
@Service

public class Userservice {
    @Autowired
    UserRepo userrepo;

    public String addnewusers(List<User> newusers) {
        getAllUsers().addAll(newusers);
        return newusers.size() + "user were added";
    }

    public List<User> getAllUsers() {
        return userrepo.getUserList();
    }


    public void deleteUserById(Integer userId) {
        List<User> users = userrepo.getUserList();
        users.removeIf(user -> user.getUserId().equals(userId));
    }

    public User updateUserById(Integer userId, User updatedUser) {
        List<User> users = userrepo.getUserList();
        for (User user : users) {
            if (user.getUserId().equals(userId)) {
                user.setUserName(updatedUser.getUserName());
                user.setUserEmail(updatedUser.getUserEmail());
                user.setUserDOB(updatedUser.getUserDOB());
                user.setUserContactNo(updatedUser.getUserContactNo());
                // Add more update logic as needed
                return user;
            }
        }
        return null;
    }
}

```
### Database Design
The project database design includes tables for user management ,with fields such as :
* userId:(userId)
* userName:(userName)
* userPhoneNumber:(userPhoneNumber)
* userAddress:(userAddress)
* userDOB:(userDOB)
* userEmail:(userEmail)
  ***
### Data Structure Used
* user Class: Defines the structure for user data,including users attributes.
* ArrayList: Utilized for managing lists og User objects efficiently.
  ***
  ### Key Points
  * RESTful API endpoints for user management.
  * clean code separation with a layered architechture(UserController,BeanBagRepository).
  * Robust error handling for improve reliability.
  * java based backend framework(Spring boot) and maven  for build management.
  * Beginner friendly
  * validation performing the data integrity.
  




  
  
  
  
