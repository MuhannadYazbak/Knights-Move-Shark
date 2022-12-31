module KnightMovesGame {
	exports controller;
	exports utils;
	exports model;

	requires java.desktop;
	requires javafx.base;
	requires transitive javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.media;
	requires json.simple;
	requires org.junit.jupiter.api;
	
	opens controller to javafx.fxml;
}