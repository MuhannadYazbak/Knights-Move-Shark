module KnightMove {
	requires javafx.fxml;
	requires javafx.controls;
	requires java.desktop;
	requires javafx.base;
	requires transitive javafx.graphics;
	requires org.json;
	exports controller;
	exports model;
	exports views;
	opens controller to javafx.graphics,javafx.fxml;
	opens model to javafx.base, javafx.fxml;
	opens views to javafx.graphics, java.desktop;
}