README - Grid Drawing Application (Q2)
--------------------------------------

Description:
This JavaFX application displays a grid similar to graph paper.
On each button press, the program fills 10% of the grid's cells randomly with black rectangles.

Instructions to Run:
1. Ensure you are using Java 8 with JavaFX support.
2. Compile all .java files inside the Q2 folder.
3. Run the Q2.java file to launch the application.
4. Click the "Draw Rect" button to randomly fill 10% of the grid.

File Contents:
- Q2.java: JavaFX application entry point. Loads the layout and starts the UI.
- Q2Controller.java: Controller that handles drawing logic for the grid.
- Q2.fxml: Defines the graphical interface using VBox layout with a button and canvas.

Notes:
- Uses a Canvas and GraphicsContext to draw the grid and fill cells.
- Each grid cell is 10x10 pixels to meet the requirement of 10-pixel spacing between lines.
- Before submission, remove the 'package' declaration from .java files and edit fx:controller in FXML to be unqualified.
