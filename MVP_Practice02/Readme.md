# MVP Implementation

A simple MVP implementation using Dager2, a login scenario as a use case.

## Blueprint:

- Each feature has a package eg. Login, Sign Up etc.
- Each package has interface of its "MVP" name.
- MVP interface has child interfaces for Model, View and Presenter.
- Model, View have separate Java classes.
- Each of above 2 classes implement their interfaces from MVP interface.
- Activity, Fragment or other UI element implements View from MVP.
- Activity holds a Presenter instance.
- Presenter is injected as a dependency.
- Model has all data related work and is accessible via interfaces.
- Model is not exposed to Framework in our case Android framework.
- Declare methods in interfaces as what would this module do, leave implementation
  to lower levels of framework in our case Android framework's Activity.
- Each feature or package has its dependencies (modules) defined in a dagger2 way.
- This is by convention and by no means is hard and fast rule to follow.
- "root" generally means Application level package.
- Presenter is a mediator between View and Model.


