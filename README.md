# ZoomPOC

First commit has the from scracth implementation, it seems doable with some more maths and case handling, but that would only be zoom. **Focalized pinch zoom would still be missing**.

**Debug APK before adding the dependency is 4.2 MB total size**

## PhotoView

[Dependency Link](https://github.com/chrisbanes/PhotoView) Thousands of stars, the owner works on Google, its been supported from a long time

After the library implementation the size is 4.4 MB

**Problem: It only zoom the image view area it doesn't fill the entire layout container**

## ZoomLayout

[Dependency Link](https://github.com/natario1/ZoomLayout) Hundreds of stars insteads of thousands, commits indicates constant support, the owner seem to be an expert on the UI it has other very famous libraries like [CameraView](https://github.com/natario1/CameraView)

After the library implementation the size is 4.2 MB

It does fill the container on zoom instead of just filling the `ImageView` the **only problem so far is some XML attrbitutes doesn't seem to work** but it surely does what is needed.

Bigger **PROBLEM** when movint to recycler view, [issues](https://github.com/natario1/ZoomLayout/issues?q=recyclerview) indicates it **is NOT supported**