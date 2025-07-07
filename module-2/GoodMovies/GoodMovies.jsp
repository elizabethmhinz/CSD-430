<!-- June 1, 2025
Module 2 Assignment - Java Scriplet - Data Display - Liz Hinz for CSD430-A339 for Professor Payne
HTML page using JSP Scriptlets that shows good movies in table format linked to CSS
 -->
 
<!-- Started with Tutorialspoint code from resources. import Java
 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.io.*,java.util.*" %>

<%
	// Set title
	String title = "Good Movies List";
	
	// Class to create strings for three records fields
	class Movie {
		String name;
		String genre;
		String director;
		
		// Constructor with three fields
		Movie(String name, String genre, String director) {
			this.name = name;
			this.genre = genre;
			this.director = director;
		}
	}
	
	// Create five records in a list with three fields
	List<Movie> movies = new ArrayList<>();
	movies.add(new Movie ("Don't Look Up", "Sci-Fi/Comedy", "Adam McKay")); 
	movies.add(new Movie ("Jojo Rabbit", "War/Comedy/Drama", "Taika Waititi"));
	movies.add(new Movie ("Shiva Baby", "Comedy/Drama", "Emma Seligman"));
	movies.add(new Movie ("Bring Her Back", "Horror", "Danny Philippou & Michael Philippou"));
	movies.add(new Movie ("The Lost Boys", "Thriller/Horror/Comedy", "Joel Schumacher"));
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="GoodMovies.css">
		<title><%= title %></title>
	</head>
	<body>
		<div class="container">
			<!-- Title & description of page -->
			<h1><%= title %></h1>
			<p>List of 5 good movies to watch including the genre and director</p>
			
			<!-- Display Good Movies table & data -->
			<table>
				<thead>
					<tr>
						<th>Movie Name</th>
						<th>Genre</th>
						<th>Director</th>
					</tr>
				</thead>
				<tbody>
					<%
						for (Movie movie : movies) {
					%>
					<tr>
						<td><%= movie.name %></td>
						<td><%= movie.genre %></td>
						<td><%= movie.director %></td>
					</tr>
					<%
						}
					%>
				</tbody>
			</table>
		</div>
	</body>
</html>