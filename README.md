[![Build Status](https://travis-ci.com/mtumilowicz/java11-lambda-type-inference.svg?branch=master)](https://travis-ci.com/mtumilowicz/java11-lambda-type-inference)

# java11-lambda-type-inference
The main goal of this project is to show how to use type inference
for lambda expressions.

_Reference_: https://medium.com/the-java-report/java-11-sneak-peek-local-variable-type-inference-var-extended-to-lambda-expression-parameters-e31e3338f1fe  
_Reference_: https://stackoverflow.com/questions/50225672/java-11-local-variable-syntax-for-lambda-parameters-applications

# preface
We have three ways to provide types to lambdas:
* **explicit**
    ```
    Predicate<String> isLowercase = (String str) -> str.equals(str.toLowerCase());
    ```
* **implicit**
    ```
    Predicate<String> isLowercase = str -> str.equals(str.toLowerCase());
    ```
* **inference**
    ```
    Predicate<String> isLowercase = (var str) -> str.equals(str.toLowerCase());
    ```
As you may see - java has two mechanisms for type inference on local 
lambda expression variables (as mentioned above - `implicit` and 
`inference`).

Previously (prior to 11), if we wanted to use modifiers on lambda formals 
we had to use explicit syntax, now it is possible to write:
```
Predicate<String> isLowercase = (@NonNull var str) -> str.equals(str.toLowerCase());
```
which is a very concise, coherent and elegant way.

# project description
In `LambdaLocalTypeInferenceTest` we provide full examples of the 
mentioned functionality.
