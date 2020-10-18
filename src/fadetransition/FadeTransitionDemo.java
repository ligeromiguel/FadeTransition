 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fadetransition;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import static javafx.scene.paint.Color.BLACK;
import static javafx.scene.paint.Color.RED;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Miguel Ligero
 */
public class FadeTransitionDemo extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Ellipse e1 = new Ellipse(110,90);
        e1.setFill(RED);
        e1.setStroke(BLACK);

        FadeTransition f1 = new FadeTransition(Duration.millis(3000), e1);
        f1.setFromValue(1.0);
        f1.setToValue(0);
        f1.setCycleCount(2);
        f1.setOnFinished(e -> f1.play());
        f1.setAutoReverse(true);
        f1.play();
        
        e1.setOnMousePressed(e -> f1.pause());
        e1.setOnMouseReleased(e -> f1.play());
        
        StackPane root = new StackPane();
        root.getChildren().add(e1);
        Scene scene = new Scene(root, 280, 250);
        
        primaryStage.setTitle("FadeTransitionDemo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
