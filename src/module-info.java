module KnightMove {
	requires javafx.fxml;
	requires javafx.controls;
	requires java.desktop;
	requires javafx.base;
	requires transitive javafx.graphics;
	exports controller;
	exports model;
	exports view;
	opens controller to javafx.graphics,javafx.fxml;
	opens model to javafx.base, javafx.fxml;
	opens view to javafx.graphics, java.desktop;
}