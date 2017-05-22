# MVP Implementation

A simple MVP implementation using Dager2, a login scenario as a use case. Here the primary objective was to make our code decoupled (less dependant) on framework (Android APIs). And also following Clean Architecture principles in the implementation.

## Blueprint:

- Each feature has a package eg. Login, Sign Up etc.
- Each package has interface of its "MVP" name.
- MVP interface has child interfaces for Model, View and Presenter.
- Model, Presenter have separate Java classes.
- Each of above 2 classes implement their interfaces from MVP interface.
- Activity, Fragment or other UI element implements View from MVP.
- Activity holds a Presenter instance.
- Presenter is injected as a dependency. (using Application object that has Dagger Component instance)
- In Dagger2 Module, Presenter is provided with its dependencies for example Model using @Provides annotation
  and in our case Model has dependency of LoginRepo which is also handled here in Module.
- Do not confuse Model with Module, **Model is data model related to MVP and Module is a dependency module related to Dagger**.
- Model has all data related work and is accessible via interfaces.
- Model is not exposed to Framework in our case Android framework.
- Declare methods in interfaces as what would this module do, leave implementation
  to lower levels of framework in our case Android framework's Activity.
- Each feature or package has its dependencies (modules) defined in a dagger2 way.
- This is by convention and by no means is hard and fast rule to follow.
- "root" generally means Application level package.
- Presenter is a mediator between View and Model.


