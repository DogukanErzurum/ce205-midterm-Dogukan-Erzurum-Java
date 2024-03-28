/**
 * @file MainMenu.java
 * @brief This file contains the main menu functionality for the local team manager application.
 */

package com.Rsuygun.localTeamManager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.Rsuygun.localTeamManager.authentication.AdminManager;
import com.Rsuygun.localTeamManager.authentication.Login;
import com.Rsuygun.localTeamManager.authentication.Register;
import com.Rsuygun.localTeamManager.communication.SendMessage;
import com.Rsuygun.localTeamManager.communication.ViewMessage;
import com.Rsuygun.localTeamManager.roaster.AddPlayer;
import com.Rsuygun.localTeamManager.roaster.EditPlayer;
import com.Rsuygun.localTeamManager.roaster.Player;
import com.Rsuygun.localTeamManager.roaster.RemovePlayer;
import com.Rsuygun.localTeamManager.roaster.ViewRoaster;
import com.Rsuygun.localTeamManager.scheduler.AddGame;
import com.Rsuygun.localTeamManager.scheduler.EditGame;
import com.Rsuygun.localTeamManager.scheduler.RemoveGame;
import com.Rsuygun.localTeamManager.scheduler.ViewSchedule;
import com.Rsuygun.localTeamManager.tracker.RecordStatistics;
import com.Rsuygun.localTeamManager.tracker.ViewPlayerStats;
import com.Rsuygun.localTeamManager.tracker.ViewTeamStats;

/**
 * @brief The main menu class for the local team manager application.
 */
public class MainMenu {
	
	/**
     * @brief The main method of the application.
     * 
     * This method handles the main menu functionality of the local team manager application,
     * including user registration, login, admin login, player transactions, match transactions,
     * statistical transactions, and messaging.
     * 
     * @param args The command-line arguments.
     */
	private static RemoveGame removeGameManager = new RemoveGame();

	private static List<Player> playerList = new ArrayList<>();
	private static AddGame addGameManager = new AddGame();

	public static void main(String[] args) {
		Register registerManager = new Register();
		Login loginManager = new Login();
		AdminManager adminManager = new AdminManager();
		Scanner scanner = new Scanner(System.in);
		boolean exitRequested = false;

		boolean isAdminLoggedIn = false;
		boolean isLoggedIn = false;

		while (true) {
			if (!isAdminLoggedIn && !isLoggedIn) {
				
				// Main menu for unauthenticated users
                // Options: Register, Login, Admin Login, Exit
                // Handle user input accordingly
				System.out.println("************************");
				System.out.println("1. Register");
				System.out.println("2. Login");
				System.out.println("3. Admin Login");
				System.out.println("5. Exit");
				System.out.println("************************");
				System.out.print("Your choice: ");
				int choice = scanner.nextInt();
				scanner.nextLine();

				switch (choice) {
				case 1:
				
					System.out.println("\n------------------------");
					System.out.println("Register");
					System.out.println("------------------------");
					System.out.print("Username: ");
					String username = scanner.nextLine();
					System.out.println("************************");
					System.out.print("Password: ");
					String password = scanner.nextLine();
					registerManager.registerUser(username, password);
					break;
				case 2:
					
					System.out.println("\n------------------------");
					System.out.println("Login");
					System.out.println("------------------------");
					System.out.print("Username: ");
					String loginUsername = scanner.nextLine();
					System.out.println("************************");
					System.out.print("Password: ");
					String loginPassword = scanner.nextLine();
					isLoggedIn = loginManager.loginUser(loginUsername, loginPassword);
					break;
				case 3:
					
					System.out.println("\n------------------------");
					System.out.println("Admin Login");
					System.out.println("------------------------");
					System.out.print("Admin Username:");
					String adminUsernameInput = scanner.nextLine();
					System.out.println("************************");
					System.out.print("Admin Password: ");
					String adminPasswordInput = scanner.nextLine();
					isAdminLoggedIn = adminManager.loginAdmin(adminUsernameInput, adminPasswordInput);
					break;
				case 4:
					
					System.out.println("Exiting the program...");
					scanner.close();
					System.exit(0);
				default:
					System.out.println("Invalid selection!");
					break;
				}
			} else if (isAdminLoggedIn) {
				
				// Admin menu
                // Options: Player Transactions, Match Transactions, Statistical Transactions,
                // Show Messages, Exit
                // Handle admin input accordingly
				System.out.println("\n------------------------");
				System.out.println("Admin menu:");
				System.out.println("************************");
				System.out.println("1. Player Transactions");
				System.out.println("2. Match Transactions");
				System.out.println("3. Statistical Transactions");
				System.out.println("4. Show Messages");
				System.out.println("5. Exit");
				System.out.println("************************");
				System.out.print("Your choice: ");
				int adminChoice = scanner.nextInt();
				scanner.nextLine(); 

				switch (adminChoice) {
				case 1:
					
					System.out.println("\n------------------------");
					System.out.println("\nPlayer Transactions:");
					System.out.println("************************");
					System.out.println("1. Add Player");
					System.out.println("2. Edit Player");
					System.out.println("3. Delete Player");
					System.out.println("4. View Squad");
					System.out.println("5. Return to Main Menu");
					System.out.println("************************");
					System.out.print("Your choice: ");
					int playerActionChoice = scanner.nextInt();
					scanner.nextLine();

					switch (playerActionChoice) {
					case 1:
						
						System.out.println("Enter the required information to add a player:");
						System.out.print("Name: ");
						String name = scanner.nextLine();
						System.out.print("Surname: ");
						String surname = scanner.nextLine();
						System.out.print("Date of birth: ");
						String birthDate = scanner.nextLine();
						System.out.print("Nationality: ");
						String nationality = scanner.nextLine();
						System.out.print("Position: ");
						String position = scanner.nextLine();
						System.out.print("Market value: ");
						double marketValue = scanner.nextDouble();
						scanner.nextLine();

						AddPlayer addPlayer = new AddPlayer(playerList);
						addPlayer.addPlayer(name, surname, birthDate, nationality, position, marketValue);
						break;
					case 2:
						
						System.out.println("Enter the ID of the player you want to edit: ");
						int editPlayerId = scanner.nextInt();
						scanner.nextLine();

						
						System.out.println("Enter the player's new information: ");
						System.out.print("Name: ");
						String newPlayerName = scanner.nextLine();
						System.out.print("Surname: ");
						String newPlayerSurname = scanner.nextLine();
						System.out.print("Date of birth: ");
						String newPlayerBirthDate = scanner.nextLine();
						System.out.print("Nationality: ");
						String newPlayerNationality = scanner.nextLine();
						System.out.print("Position: ");
						String newPlayerPosition = scanner.nextLine();
						System.out.print("Market value: ");
						double newPlayerMarketValue = scanner.nextDouble();
						scanner.nextLine(); 
						
						EditPlayer editPlayer = new EditPlayer(playerList);
						editPlayer.editPlayer(editPlayerId, newPlayerName, newPlayerSurname, newPlayerBirthDate,
								newPlayerNationality, newPlayerPosition, newPlayerMarketValue);
						break;
					case 3:
					
						System.out.println("Enter the ID of the player you want to delete:");
						int deletePlayerId = scanner.nextInt();
						scanner.nextLine();

						
						RemovePlayer removePlayer = new RemovePlayer(playerList);
						removePlayer.removePlayer(deletePlayerId);
						break;
					case 4:
						
						System.out.println("Squad:");
						ViewRoaster viewRoster = new ViewRoaster(playerList);
						viewRoster.readPlayersFromFile();
						break;
					case 5:
						exitRequested = true;
						break;
					default:
						System.out.println("Invalid selection!");
						break;
					}
					break;
				case 2:
					
					System.out.println("\n------------------------");
					System.out.println("\nMatch Transactions:");
					System.out.println("************************");
					System.out.println("1. Add Match");
					System.out.println("2. View Matches");
					System.out.println("3. Delete Match");
					System.out.println("4. Edit Match");
					System.out.println("5. Return to Main Menu");
					System.out.println("************************");
					System.out.print("Your choice: ");
					int gameActionChoice = scanner.nextInt();
					scanner.nextLine(); 

					switch (gameActionChoice) {
					case 1:
						
						System.out.println("Enter the required information to add a match:");
						System.out.print("Date (yyyy-MM-dd): ");
						String dateStr = scanner.nextLine();
						System.out.print("Hour (HH:mm): ");
						String time = scanner.nextLine();
						System.out.print("Location: ");
						String location = scanner.nextLine();
						
						try {
							SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
							Date date = dateFormat.parse(dateStr);
							addGameManager.addGame(date, time, location);
							System.out.println("Match added successfully.");
						} catch (ParseException e) {
							System.out.println("Invalid date/time format. Match could not be added.");
						}
						break;
					case 2:
					
						System.out.println("View Matches");
						ViewSchedule viewSchedule = new ViewSchedule();
						viewSchedule.loadGamesFromFile("game.txt");
						viewSchedule.displaySchedule();
						break;
					case 3:
						
						System.out.println("To delete a match, enter the match ID:");
						int gameIdToDelete = scanner.nextInt();
						scanner.nextLine();
						removeGameManager.removeGame(gameIdToDelete);
						System.out.println("The match was successfully deleted.");
						break;
					case 4:
						
						System.out.println("To edit a match, enter the match ID:");
						int gameIdToEdit = scanner.nextInt();
						scanner.nextLine();

						System.out.println("Enter new date (in yyyy-MM-dd format):");
						String newDateStr = scanner.nextLine();
						System.out.println("Enter new time (in HH:mm format):");
						String newTime = scanner.nextLine();
						System.out.println("Enter the new location:");
						String newLocation = scanner.nextLine();
						System.out.println("Enter the new opposing team:");
						String newOpponent = scanner.nextLine();

						EditGame editGame = new EditGame(addGameManager.getGames());
						editGame.editGame(gameIdToEdit, newDateStr, newTime, newLocation, newOpponent);
						break;
					case 5:
						exitRequested = true;
						break;
					default:
						System.out.println("Invalid selection!");
						break;
					}
					break;
				case 3:
					
					System.out.println("\n------------------------");
					System.out.println("\nStatistical Transactions:");
					System.out.println("************************");
					System.out.println("1. Add Statistics");
					System.out.println("2. View Player Statistics");
					System.out.println("3. View Team Statistics");
					System.out.println("4. Return to Main Menu");
					System.out.println("************************");
					System.out.print("Your choice: ");
					int statActionChoice = scanner.nextInt();
					scanner.nextLine(); 

					switch (statActionChoice) {
					case 1:
						
						System.out.print("Player ID: ");
						int playerId = scanner.nextInt();
						System.out.print("Number of Goals: ");
						int goals = scanner.nextInt();
						System.out.print("Number of Assists: ");
						int assists = scanner.nextInt();
						System.out.print("Number of Yellow Cards: ");
						int yellowCards = scanner.nextInt();
						System.out.print("Number of Red Cards: ");
						int redCards = scanner.nextInt();
						RecordStatistics recordStatistics = new RecordStatistics();
						recordStatistics.addStatistics(playerId, goals, assists, yellowCards, redCards);
						break;
					case 2:
						
						System.out.print("Player ID: ");
						int playerStatisticId = scanner.nextInt();
						ViewPlayerStats viewPlayerStats = new ViewPlayerStats();
						viewPlayerStats.displayPlayerStats(playerStatisticId);
						break;
					case 3:
						
						ViewTeamStats viewTeamStats = new ViewTeamStats();
						viewTeamStats.displayTeamStats();
						break;
					case 4:
						exitRequested = true;
						break;
					default:
						System.out.println("Invalid selection!");
						break;
					}
					break;
				case 4:
					
					ViewMessage viewMessage = new ViewMessage();
					viewMessage.displayAllMessages();
					break;
				case 6:
					
					System.out.println("Exiting the program...");
					scanner.close();
					System.exit(0);
				default:
					System.out.println("Invalid selection!");
					break;
				}
			} else if (isLoggedIn) {
				
				// User menu
                // Options: View Squad, View Matches, Send Message, Exit
                // Handle user input accordingly
				System.out.println("\n------------------------");
				System.out.println("\nUser menu:");
				System.out.println("************************");
				System.out.println("1. View Squad");
				System.out.println("2. View Matches");
				System.out.println("3. Send Message");
				System.out.println("4. Exit");
				System.out.println("************************");
				System.out.print("Your choice: ");
				int userChoice = scanner.nextInt();
				scanner.nextLine(); 

				switch (userChoice) {
				case 1:
					
					System.out.println("Squad:");
					ViewRoaster viewRoster = new ViewRoaster(playerList);
					viewRoster.readPlayersFromFile();
					break;
				case 2:
					
					System.out.println("View Matches");
					ViewSchedule viewSchedule = new ViewSchedule();
					viewSchedule.loadGamesFromFile("game.txt");
					viewSchedule.displaySchedule();
					break;
				case 3:
					
					SendMessage sendMessage = new SendMessage();
					System.out.println("Enter the player ID you want to send a message to:");
					int playerIdToSendMessage = scanner.nextInt();
					scanner.nextLine();
					System.out.println("Enter the message you want to send:");
					String messageToSend = scanner.nextLine();
					sendMessage.sendMessageToPlayer(playerIdToSendMessage, messageToSend);
					break;
				case 4:
					
					System.out.println("Exiting the program...");
					scanner.close();
					System.exit(0);
				default:
					System.out.println("Invalid selection!");
					break;
				}
			}
		}
	}
}