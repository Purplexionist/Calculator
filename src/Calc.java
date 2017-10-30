import javafx.geometry.Insets;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Calc extends Application {
	Compute computer;
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Calculator");
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.TOP_CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));

		Scene scene = new Scene(grid, 300, 275);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		Label firstNum = new Label("First Number:");
		grid.add(firstNum, 0, 1);
		Text scenetitle = new Text("Calculator");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		grid.add(scenetitle, 0, 0, 2, 1);
		TextField firstText = new TextField();
		grid.add(firstText, 1, 1);
		Label secondNum = new Label("Second Number:");
		grid.add(secondNum, 0, 2);
		TextField secondText = new TextField();
		grid.add(secondText, 1, 2);
		
		Button btn1 = new Button("+");
		Button btn2 = new Button("-");
		Button btn3 = new Button("*");
		Button btn4 = new Button("/");
		HBox hbBtn = new HBox(20);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(btn1);
		hbBtn.getChildren().add(btn2);
		hbBtn.getChildren().add(btn3);
		hbBtn.getChildren().add(btn4);
		grid.add(hbBtn,  0,  3);
		final Text actiontarget = new Text();
		grid.add(actiontarget,  0,  6);
		ComputeFactory computeFactory = new ComputeFactory();
		btn1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				actiontarget.setFill(Color.RED);
				String a = firstText.getText();
				int a1 = Integer.parseInt(a);
				int b1 = Integer.parseInt(secondText.getText());
				computer = computeFactory.getCompute("Add");
				String b = Double.toString(computer.compute(a1, b1));
				actiontarget.setText(b);
			}
		});
		btn2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				actiontarget.setFill(Color.RED);
				String a = firstText.getText();
				int a1 = Integer.parseInt(a);
				int b1 = Integer.parseInt(secondText.getText());
				computer = computeFactory.getCompute("Sub");
				String b = Double.toString(computer.compute(a1, b1));
				actiontarget.setText(b);
			}
		});
		btn3.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				actiontarget.setFill(Color.RED);
				String a = firstText.getText();
				float a1 = Float.parseFloat(a);
				float b1 = Float.parseFloat(secondText.getText());
				computer = computeFactory.getCompute("Mult");
				String b = Double.toString(computer.compute(a1, b1));
				actiontarget.setText(b);
			}
		});
		btn4.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				actiontarget.setFill(Color.RED);
				String a = firstText.getText();
				float a1 = Float.parseFloat(a);
				float b1 = Float.parseFloat(secondText.getText());
				computer = computeFactory.getCompute("Div");
				String b = Double.toString(computer.compute(a1, b1));
				actiontarget.setText(b);
			}
		});
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
