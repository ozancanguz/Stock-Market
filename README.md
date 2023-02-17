# Stock-Market

-I have built a stock market app that we can find gold,
crypto,stock,parity and ware price list and all the details we need.


# DEMO 

![stock market 11](https://user-images.githubusercontent.com/64928807/209528138-fc07441b-0786-42b8-a91a-09d2439bef47.gif)
![stock market 2](https://user-images.githubusercontent.com/64928807/209528269-543e9d09-cd63-4713-bacd-644e296825dc.gif)


# Architecture


This app implements MVVM architecture. App consist of different fragments and 1 root activity. Activity holds a container layout in order to manage fragments which will be controlled by navigation component. Here is the package structure:

![image](https://user-images.githubusercontent.com/64928807/219080594-d41f9c5c-6621-44dd-be6a-7fb2424b9150.png)



Data

Data package should include response models, data source. It shouldn't know any logic.

UI

UI like a feature. It contains Fragments,  and feature related classes like a domains, mappers and ui models. Make sure that all classes here are specific to the this feature. If it is a class that is also used in other features, it should be moved to the common package.

Di

This package may actually be inside the common module. But I prefer to carry outside of core package to be more visible.

Viewmodel

This package includes viewmodels.

Util

This package include utility class that has glide image loading etc.

**Tools that I used** :

- Navigation Component
- Hilt for dependency injection
- Retrofit 
- Postman for Api testing.
- Coroutines 
- Livedata.
- View Binding
- Glide for image loading
- RESTApi
- Figma



