module KnightMovesGame {
	exports controller;
	exports utils;
	exports model;

	requires java.desktop;
	requires javafx.base;
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.media;
	requires json.simple;
	
	opens controller to javafx.fxml;
}