# Dagger2 

Simple dagger2 implementations.

## Notes
- Each dependency is provided by a method in dagger2 "Module" using "@Provides" annotation.
- Modules are accessed via dagger2 "Components".
- Scopes defines dependency scope, like life of an object in Activty or whole Application before it is destroyed.
- dagger2 "Qualifiers" are used to distinguish dependencies with any other provider that is returning. same type of dependency.
- Following annotation means search for dependencies in these listed modules or components in some cases:
  ```@Component(modules = {PicassoModule.class})```
- We can also include components with other component to use dependencies defined in the different components. Example:

  ```@Component(modules = {MainActivityModule.class}, dependencies = {ApplicationContextComponent.class})```
- See [MainActivity.java](https://github.com/talhahasanzia/mvp-samples/blob/master/1-%20Dagger2/app/src/main/java/com/example/mvp_practice01/MainActivity.java) for how to use @inject annotations.


