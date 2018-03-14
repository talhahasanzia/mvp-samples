# Mockito
Simple implementation of mockito using Login use case. MVP provided us with almost no dependency on android framework,
so we used plain JUnit tests using mock objects and tested our functions. We did not use androidTest which execurtes on DVM,
instead of JVM like simple JUnit tests. Normally we use espresso to write androidTests, but JVM only tests are faster and the 
fact that they follow MVP they are closer to obey Clean Architecture.

### [Jump to test package ](https://github.com/talhahasanzia/mvp-samples/blob/master/Testing/app/src/test/java/com/example/mvp_practice02/)

## Notes
- Presenter is to be tested so it has concrete class implementation.
- Model and Views are abstract class objects.
- We use  ```mockModel = mock( LoginActivityMVP.Model.class )``` to mock objects.
- We use ```when( object.method() ).thenReturn( thisValue )```  to set mock behavior on a method.
- We use following methods to test case our scenario:

  ```verify( mockView, times( 1 ) ).mockMethod()```    // verify that mockView's mockMethod was called 1 time.
  
  ```verify( mockView, times( 5 ) ).mockMethod()```    // verify that mockView's mockMethod was called 5 times.
  
  ```verify( mockView, never ).mockMethod()```    // verify that mockView's mockMethod was never called.

        
