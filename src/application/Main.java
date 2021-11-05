package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;


public class Main extends Application {
	private TextField t1 = new TextField();
	private TextField t2 = new TextField();
	private TextField t3 = new TextField();
	private TextField t4 = new TextField();
	
	@Override
	public void start(Stage primaryStage) {
		
		try {
			
			GridPane gridPane = new GridPane();
			
			Label l1 = new Label("投资总额");
			Label l2 = new Label("投资年数");
			Label l3 = new Label("年利率");
			Label l4 = new Label("未来值");
			
			Button btSum = new Button("计算");
			
			gridPane.add(l1, 0, 0);
			gridPane.add(l2, 0, 1);
			gridPane.add(l3, 0, 2);
			gridPane.add(l4, 0, 3);
			
			gridPane.add(t1, 1, 0);
			gridPane.add(t2, 1, 1);
			gridPane.add(t3, 1, 2);
			gridPane.add(t4, 1, 3);
			
			gridPane.add(btSum, 1, 4);
			
			gridPane.setHgap(10);
			gridPane.setVgap(10);
			
			gridPane.setPadding(new Insets(10));
			
			GridPane.setHalignment(btSum, HPos.RIGHT);
			
			btSum.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					calculateLoanPayment();
				}
			});
			
			Scene scene = new Scene(gridPane);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			primaryStage.setTitle("投资计算器");
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void calculateLoanPayment() {
		double monthRate = (Double.parseDouble(t3.getText())) / 1200;
		int year = Integer.parseInt(t2.getText());
		double total = Double.parseDouble(t1.getText());
		
		Loan loan = new Loan(monthRate, year, total);
		
		t4.setText(String.format("%.2f", loan.getTotalPayment()));
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
