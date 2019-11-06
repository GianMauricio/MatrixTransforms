# MatrixTransforms
This is a simple project with the goal of accurately rotating certain points of an input. It will be coded in Java and outputs a text file of converted points depending on the things the user has chosen to do.

Matrix composition is handled dynamically after each transformation is performed, using the logic of left-most transform, composing the current version of the final transform matrix onto the latest transform matrix. In short, multiply the next transform to the current composed transformation matrix.


Logic sources:
  https://www.tutorialspoint.com/computer_graphics/3d_transformation.htm
    - Rotation
    - Distortion