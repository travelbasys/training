package experiment.statistik;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;

/**
 * Controller Klasse für unser Dialogfenster.
 * 
 * <p>
 * Alle von FXML benutzten Properties und Methoden sind private.
 * </p>
 * 
 * @author isenbuegel
 */
public class MainController {

	@FXML
	private static Button button;
	@FXML
	private static Button openButton;
	@FXML
	private static Button showChart2;
	@FXML
	private static LineChart<String, Integer> lineChart;
	@FXML
	private static BarChart<String, Integer> barChart;
	@FXML
	private static CategoryAxis categoryAxis;
	@FXML
	private static NumberAxis numberAxis;
	@FXML
	private static CategoryAxis xAxis;
	@FXML
	private static NumberAxis yAxis;
	private static ArrayList<ReportRecord> reportRecords;

	private static final String RBS_WEB = "RBSweb";
	private static final String WEB_SERVICE = "webService";

	@FXML
	private static void openFile() {
		FileChooser fileChooser = new FileChooser();

		// Set extension filter
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
				"CSV files (*.csv)", "*.csv");
		fileChooser.getExtensionFilters().add(extFilter);

		// Show open file dialog
		File inputFile = fileChooser.showOpenDialog(null);

		System.out.println(inputFile);

		// Datei lesen

		try {
			@SuppressWarnings("deprecation")
			URL url = inputFile.toURL();

			BetterBufferedReader reader = new BetterBufferedReader(
					new InputStreamReader(url.openStream()));

			reportRecords = new ArrayList<ReportRecord>();
			StringTokenizer st = null;
			String line;

			// The first line contains the column names. We must skip it.
			reader.skipLines(1);
			while ((line = reader.readLine()) != null) {
				ReportRecord rr = new ReportRecord();
				st = new StringTokenizer(line, ";");

				try {
					rr.datum = st.nextToken();
					rr.menu = st.nextToken();
					rr.menuTyp = st.nextToken();
					rr.menuText = st.nextToken();
					rr.stunde = st.nextToken();
					rr.anzStunde = new Integer(st.nextToken());
				} catch (Exception e) {
					// Wir ignorieren Records, die einen ungültigen (z.B.
					// leeren) Wert enthalten.
					continue;
				}
				reportRecords.add(rr);
			}
			reader.close();
		} catch (IOException io) {
		}
	}

	@SuppressWarnings("unchecked")
	@FXML
	private static void showChart1() throws Exception {

		// Diese Variablen haben folgende Aufgabe: ...
		int sumStundeRBSweb = -1;
		int sumStundeWebService = -1;

		// Create two data series: one for RBSweb values, one for WebService
		// values.
		XYChart.Series<String, Integer> seriesRBSweb = new XYChart.Series<String, Integer>();
		XYChart.Series<String, Integer> seriesWebService = new XYChart.Series<String, Integer>();

		// Process all report records.
		// For each day we sum up the number of RBSweb and WebService requests
		// on that day.

		// Day before current day.
		String vortag = null;
		for (ReportRecord rr : reportRecords) {
			if (vortag == null) {
				vortag = rr.datum;

				// Initialize sums.
				sumStundeRBSweb = 0;
				sumStundeWebService = 0;

				continue;
			} else {
				// Wenn aktuelles Datum gleich Vortagesdatum...
				if (vortag.equals(rr.datum)) {
					// ... we increment one of our sums depending on menuTyp.
					if (rr.menuTyp.equals(WEB_SERVICE)) {
						sumStundeWebService = sumStundeWebService
								+ rr.anzStunde;
					} else if (rr.menuTyp.equals(RBS_WEB)) {
						sumStundeRBSweb = sumStundeRBSweb + rr.anzStunde;
					} else {
						throw new Exception("Unknown menuTyp: " + rr.menuTyp);
					}
				} else {
					// ... Neuer Tag.

					// Wir geben die bisher aufgelaufenen Summen aus.
					Data<String, Integer> objRBSweb = new XYChart.Data<String, Integer>(
							vortag, sumStundeRBSweb);
					Data<String, Integer> objWebService = new XYChart.Data<String, Integer>(
							vortag, sumStundeWebService);

					seriesRBSweb.getData().add(objRBSweb);
					seriesWebService.getData().add(objWebService);

					vortag = rr.datum;
					// Wir merken uns das aktuelle Datum.

					// Und jetzt fangen wir mit neuen Summen an.
					if (rr.menuTyp.equals(WEB_SERVICE)) {
						sumStundeWebService = rr.anzStunde;
						sumStundeRBSweb = 0;
					} else if (rr.menuTyp.equals(RBS_WEB)) {
						sumStundeRBSweb = rr.anzStunde;
						sumStundeWebService = 0;
					} else {
						throw new Exception("Unknown menuTyp: " + rr.menuTyp);
					}
				}
			}
		}

		// We create data objects for the last day and store them.
		Data<String, Integer> objRBSweb = new XYChart.Data<String, Integer>(
				vortag, sumStundeRBSweb);
		Data<String, Integer> objWebService = new XYChart.Data<String, Integer>(
				vortag, sumStundeWebService);

		seriesRBSweb.getData().add(objRBSweb);
		seriesWebService.getData().add(objWebService);

		// Add our two series objects to the chart.
		lineChart.getData().addAll(seriesRBSweb, seriesWebService);

	}

	@SuppressWarnings("unchecked")
	@FXML
	private static void showChart2() {
		XYChart.Series<String, Integer> series1 = new XYChart.Series<String, Integer>();
		XYChart.Series<String, Integer> series2 = new XYChart.Series<String, Integer>();

		int anz1 = 0;
		int anz2 = 0;
		int anz3 = 0;
		int anz4 = 0;
		int anz5 = 0;
		int anz6 = 0;
		int anz7 = 0;
		int anz8 = 0;
		int anz9 = 0;
		int anz10 = 0;
		int anz11 = 0;
		int anz12 = 0;
		int anz13 = 0;
		int anz14 = 0;
		int anz15 = 0;
		int anz16 = 0;
		int anz17 = 0;
		int anz18 = 0;
		int anz19 = 0;
		int anz20 = 0;
		int anz21 = 0;
		int anz22 = 0;
		int anz23 = 0;
		int anz24 = 0;
		int anz1a = 0;
		int anz2a = 0;
		int anz3a = 0;
		int anz4a = 0;
		int anz5a = 0;
		int anz6a = 0;
		int anz7a = 0;
		int anz8a = 0;
		int anz9a = 0;
		int anz10a = 0;
		int anz11a = 0;
		int anz12a = 0;
		int anz13a = 0;
		int anz14a = 0;
		int anz15a = 0;
		int anz16a = 0;
		int anz17a = 0;
		int anz18a = 0;
		int anz19a = 0;
		int anz20a = 0;
		int anz21a = 0;
		int anz22a = 0;
		int anz23a = 0;
		int anz24a = 0;

		for (ReportRecord rr : reportRecords) {
			if (rr.stunde.equals("1")) {
				if (rr.menuTyp.equals("RBSweb")) {
					anz1 += rr.anzStunde;
				} else {
					anz1a += rr.anzStunde;
				}
				rr.anzStunde = 0;
				continue;
			} else {
				if (rr.stunde.equals("2")) {
					if (rr.menuTyp.equals("RBSweb")) {
						anz2 += rr.anzStunde;
					} else {
						anz2a += rr.anzStunde;
					}
					rr.anzStunde = 0;
					continue;
				} else {
					if (rr.stunde.equals("3")) {
						if (rr.menuTyp.equals("RBSweb")) {
							anz3 += rr.anzStunde;
						} else {
							anz3a += rr.anzStunde;
						}
						rr.anzStunde = 0;
						continue;
					} else {
						if (rr.stunde.equals("4")) {
							if (rr.menuTyp.equals("RBSweb")) {
								anz4 += rr.anzStunde;
							} else {
								anz4a += rr.anzStunde;
							}
							rr.anzStunde = 0;
							continue;
						} else {
							if (rr.stunde.equals("5")) {
								if (rr.menuTyp.equals("RBSweb")) {
									anz5 += rr.anzStunde;
								} else {
									anz5a += rr.anzStunde;
								}
								rr.anzStunde = 0;
								continue;
							} else {
								if (rr.stunde.equals("6")) {
									if (rr.menuTyp.equals("RBSweb")) {
										anz6 += rr.anzStunde;
									} else {
										anz6a += rr.anzStunde;
									}
									rr.anzStunde = 0;
									continue;
								} else {
									if (rr.stunde.equals("7")) {
										if (rr.menuTyp.equals("RBSweb")) {
											anz7 += rr.anzStunde;
										} else {
											anz7a += rr.anzStunde;
										}
										rr.anzStunde = 0;
										continue;
									} else {
										if (rr.stunde.equals("8")) {
											if (rr.menuTyp.equals("RBSweb")) {
												anz8 += rr.anzStunde;
											} else {
												anz8a += rr.anzStunde;
											}
											rr.anzStunde = 0;
											continue;
										} else {
											if (rr.stunde.equals("9")) {
												if (rr.menuTyp.equals("RBSweb")) {
													anz9 += rr.anzStunde;
												} else {
													anz9a += rr.anzStunde;
												}
												rr.anzStunde = 0;
												continue;
											} else {
												if (rr.stunde.equals("10")) {
													if (rr.menuTyp
															.equals("RBSweb")) {
														anz10 += rr.anzStunde;
													} else {
														anz10a += rr.anzStunde;
													}
													rr.anzStunde = 0;
													continue;
												} else {
													if (rr.stunde.equals("11")) {
														if (rr.menuTyp
																.equals("RBSweb")) {
															anz11 += rr.anzStunde;
														} else {
															anz11a += rr.anzStunde;
														}
														rr.anzStunde = 0;
														continue;
													} else {
														if (rr.stunde
																.equals("12")) {
															if (rr.menuTyp
																	.equals("RBSweb")) {
																anz12 += rr.anzStunde;
															} else {
																anz12a += rr.anzStunde;
															}
															rr.anzStunde = 0;
															continue;
														} else {
															if (rr.stunde
																	.equals("13")) {
																if (rr.menuTyp
																		.equals("RBSweb")) {
																	anz13 += rr.anzStunde;
																} else {
																	anz13a += rr.anzStunde;
																}
																rr.anzStunde = 0;
																continue;
															} else {
																if (rr.stunde
																		.equals("14")) {
																	if (rr.menuTyp
																			.equals("RBSweb")) {
																		anz14 += rr.anzStunde;
																	} else {
																		anz14a += rr.anzStunde;
																	}
																	rr.anzStunde = 0;
																	continue;
																} else {
																	if (rr.stunde
																			.equals("15")) {
																		if (rr.menuTyp
																				.equals("RBSweb")) {
																			anz15 += rr.anzStunde;
																		} else {
																			anz15a += rr.anzStunde;
																		}
																		rr.anzStunde = 0;
																		continue;
																	} else {
																		if (rr.stunde
																				.equals("16")) {
																			if (rr.menuTyp
																					.equals("RBSweb")) {
																				anz16 += rr.anzStunde;
																			} else {
																				anz16a += rr.anzStunde;
																			}
																			rr.anzStunde = 0;
																			continue;
																		} else {
																			if (rr.stunde
																					.equals("17")) {
																				if (rr.menuTyp
																						.equals("RBSweb")) {
																					anz17 += rr.anzStunde;
																				} else {
																					anz17a += rr.anzStunde;
																				}
																				rr.anzStunde = 0;
																				continue;
																			} else {
																				if (rr.stunde
																						.equals("18")) {
																					if (rr.menuTyp
																							.equals("RBSweb")) {
																						anz18 += rr.anzStunde;
																					} else {
																						anz18a += rr.anzStunde;
																					}
																					rr.anzStunde = 0;
																					continue;
																				} else {
																					if (rr.stunde
																							.equals("19")) {
																						if (rr.menuTyp
																								.equals("RBSweb")) {
																							anz19 += rr.anzStunde;
																						} else {
																							anz19a += rr.anzStunde;
																						}
																						rr.anzStunde = 0;
																						continue;
																					} else {
																						if (rr.stunde
																								.equals("20")) {
																							if (rr.menuTyp
																									.equals("RBSweb")) {
																								anz20 += rr.anzStunde;
																							} else {
																								anz20a += rr.anzStunde;
																							}
																							rr.anzStunde = 0;
																							continue;
																						} else {
																							if (rr.stunde
																									.equals("21")) {
																								if (rr.menuTyp
																										.equals("RBSweb")) {
																									anz21 += rr.anzStunde;
																								} else {
																									anz21a += rr.anzStunde;
																								}
																								rr.anzStunde = 0;
																								continue;
																							} else {
																								if (rr.stunde
																										.equals("22")) {
																									if (rr.menuTyp
																											.equals("RBSweb")) {
																										anz22 += rr.anzStunde;
																									} else {
																										anz22a += rr.anzStunde;
																									}
																									rr.anzStunde = 0;
																									continue;
																								} else {
																									if (rr.stunde
																											.equals("23")) {
																										if (rr.menuTyp
																												.equals("RBSweb")) {
																											anz23 += rr.anzStunde;
																										} else {
																											anz23a += rr.anzStunde;
																										}
																										rr.anzStunde = 0;
																										continue;
																									} else {
																										if (rr.stunde
																												.equals("24")) {
																											if (rr.menuTyp
																													.equals("RBSweb")) {
																												anz24 += rr.anzStunde;
																											} else {
																												anz24a += rr.anzStunde;
																											}
																											rr.anzStunde = 0;
																											continue;
																										}
																									}
																								}
																							}
																						}
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}

		Data<String, Integer> obj1 = new XYChart.Data<String, Integer>("1",
				anz1);
		Data<String, Integer> obj2 = new XYChart.Data<String, Integer>("2",
				anz2);
		Data<String, Integer> obj3 = new XYChart.Data<String, Integer>("3",
				anz3);
		Data<String, Integer> obj4 = new XYChart.Data<String, Integer>("4",
				anz4);
		Data<String, Integer> obj5 = new XYChart.Data<String, Integer>("5",
				anz5);
		Data<String, Integer> obj6 = new XYChart.Data<String, Integer>("6",
				anz6);
		Data<String, Integer> obj7 = new XYChart.Data<String, Integer>("7",
				anz7);
		Data<String, Integer> obj8 = new XYChart.Data<String, Integer>("8",
				anz8);
		Data<String, Integer> obj9 = new XYChart.Data<String, Integer>("9",
				anz9);
		Data<String, Integer> obj10 = new XYChart.Data<String, Integer>("10",
				anz10);
		Data<String, Integer> obj11 = new XYChart.Data<String, Integer>("11",
				anz11);
		Data<String, Integer> obj12 = new XYChart.Data<String, Integer>("12",
				anz12);
		Data<String, Integer> obj13 = new XYChart.Data<String, Integer>("13",
				anz13);
		Data<String, Integer> obj14 = new XYChart.Data<String, Integer>("14",
				anz14);
		Data<String, Integer> obj15 = new XYChart.Data<String, Integer>("15",
				anz15);
		Data<String, Integer> obj16 = new XYChart.Data<String, Integer>("16",
				anz16);
		Data<String, Integer> obj17 = new XYChart.Data<String, Integer>("17",
				anz17);
		Data<String, Integer> obj18 = new XYChart.Data<String, Integer>("18",
				anz18);
		Data<String, Integer> obj19 = new XYChart.Data<String, Integer>("19",
				anz19);
		Data<String, Integer> obj20 = new XYChart.Data<String, Integer>("20",
				anz20);
		Data<String, Integer> obj21 = new XYChart.Data<String, Integer>("21",
				anz21);
		Data<String, Integer> obj22 = new XYChart.Data<String, Integer>("22",
				anz22);
		Data<String, Integer> obj23 = new XYChart.Data<String, Integer>("23",
				anz23);
		Data<String, Integer> obj24 = new XYChart.Data<String, Integer>("24",
				anz24);

		series1.getData().addAll(obj1, obj2, obj3, obj4, obj5, obj6, obj7,
				obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16,
				obj17, obj18, obj19, obj20, obj21, obj22, obj23, obj24);

		Data<String, Integer> obj1a = new XYChart.Data<String, Integer>("1",
				anz1a);
		Data<String, Integer> obj2a = new XYChart.Data<String, Integer>("2",
				anz2a);
		Data<String, Integer> obj3a = new XYChart.Data<String, Integer>("3",
				anz3a);
		Data<String, Integer> obj4a = new XYChart.Data<String, Integer>("4",
				anz4a);
		Data<String, Integer> obj5a = new XYChart.Data<String, Integer>("5",
				anz5a);
		Data<String, Integer> obj6a = new XYChart.Data<String, Integer>("6",
				anz6a);
		Data<String, Integer> obj7a = new XYChart.Data<String, Integer>("7",
				anz7a);
		Data<String, Integer> obj8a = new XYChart.Data<String, Integer>("8",
				anz8a);
		Data<String, Integer> obj9a = new XYChart.Data<String, Integer>("9",
				anz9a);
		Data<String, Integer> obj10a = new XYChart.Data<String, Integer>("10",
				anz10a);
		Data<String, Integer> obj11a = new XYChart.Data<String, Integer>("11",
				anz11a);
		Data<String, Integer> obj12a = new XYChart.Data<String, Integer>("12",
				anz12a);
		Data<String, Integer> obj13a = new XYChart.Data<String, Integer>("13",
				anz13a);
		Data<String, Integer> obj14a = new XYChart.Data<String, Integer>("14",
				anz14a);
		Data<String, Integer> obj15a = new XYChart.Data<String, Integer>("15",
				anz15a);
		Data<String, Integer> obj16a = new XYChart.Data<String, Integer>("16",
				anz16a);
		Data<String, Integer> obj17a = new XYChart.Data<String, Integer>("17",
				anz17a);
		Data<String, Integer> obj18a = new XYChart.Data<String, Integer>("18",
				anz18a);
		Data<String, Integer> obj19a = new XYChart.Data<String, Integer>("19",
				anz19a);
		Data<String, Integer> obj20a = new XYChart.Data<String, Integer>("20",
				anz20a);
		Data<String, Integer> obj21a = new XYChart.Data<String, Integer>("21",
				anz21a);
		Data<String, Integer> obj22a = new XYChart.Data<String, Integer>("22",
				anz22a);
		Data<String, Integer> obj23a = new XYChart.Data<String, Integer>("23",
				anz23a);
		Data<String, Integer> obj24a = new XYChart.Data<String, Integer>("24",
				anz24a);

		series2.getData().addAll(obj1a, obj2a, obj3a, obj4a, obj5a, obj6a,
				obj7a, obj8a, obj9a, obj10a, obj11a, obj12a, obj13a, obj14a,
				obj15a, obj16a, obj17a, obj18a, obj19a, obj20a, obj21a, obj22a,
				obj23a, obj24a);
		// grün ist RBSweb, gelb webService
		barChart.getData().addAll(series1, series2);
	}
}
