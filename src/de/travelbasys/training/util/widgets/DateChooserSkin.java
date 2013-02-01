package de.travelbasys.training.util.widgets;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;

import com.sun.javafx.scene.control.behavior.BehaviorBase;
import com.sun.javafx.scene.control.skin.SkinBase;

public class DateChooserSkin extends
		SkinBase<DateChooser, BehaviorBase<DateChooser>> {

	private final Date date;
	private final Label month;
	private final BorderPane content;
	final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMMMM yyyy");

	private static class CalendarCell extends StackPane {
		private final Date date;

		public CalendarCell(Date day, String text) {
			this.date = day;
			Label label = new Label(text);
			getChildren().add(label);
		}

		public Date getDate() {
			return date;
		}
	}

	public DateChooserSkin(DateChooser dateChooser) {
		super(dateChooser, new BehaviorBase<DateChooser>(dateChooser));
		// this date is the selected date
		date = dateChooser.getDate();
		final DatePickerPane calendarPane = new DatePickerPane(date);

		month = new Label(simpleDateFormat.format(calendarPane.getShownMonth()));
		HBox hbox = new HBox();

		// create the navigation Buttons
		Button yearBack = new Button("<<");
		yearBack.addEventHandler(ActionEvent.ACTION,
				new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {
						calendarPane.forward(-12);

					}
				});
		Button monthBack = new Button("<");
		monthBack.addEventHandler(ActionEvent.ACTION,
				new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {
						calendarPane.forward(-1);
					}
				});
		Button monthForward = new Button(">");
		monthForward.addEventHandler(ActionEvent.ACTION,
				new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {
						calendarPane.forward(1);
					}
				});
		Button yearForward = new Button(">>");
		yearForward.addEventHandler(ActionEvent.ACTION,
				new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {
						calendarPane.forward(12);
					}
				});

		// center the label and make it grab all free space
		HBox.setHgrow(month, Priority.ALWAYS);
		month.setMaxWidth(Double.MAX_VALUE);
		month.setAlignment(Pos.CENTER);
		hbox.getChildren().addAll(yearBack, monthBack, month, monthForward,
				yearForward);

		// use a BorderPane to Layout the view
		content = new BorderPane();
		getChildren().add(content);
		content.setTop(hbox);
		content.setCenter(calendarPane);
	}

	/**
	 * @author eppleton
	 */
	class DatePickerPane extends Region {

		private final Date selectedDate;
		private final Calendar cal;
		private CalendarCell selectedDayCell;
		// this is used to format the day cells
		private final SimpleDateFormat sdf = new SimpleDateFormat("d");
		// empty cell header of weak-of-year row
		private final CalendarCell woyCell = new CalendarCell(new Date(), "");
		private int rows, columns;// default

		public DatePickerPane(Date date) {
			setPrefSize(300, 300);
			woyCell.getStyleClass().add("week-of-year-cell");
			setPadding(new Insets(5, 0, 5, 0));
			this.columns = 7;
			this.rows = 5;

			// use a copy of Date, because it's mutable
			// we'll helperDate it through the month
			cal = Calendar.getInstance();
			Date helperDate = new Date(date.getTime());
			cal.setTime(helperDate);

			// the selectedDate is the date we will change, when a date is
			// picked
			selectedDate = date;
			refresh();
		}

		/**
		 * Move forward the specified number of Months, move backward by using
		 * negative numbers
		 * 
		 * @param i
		 */
		public void forward(int i) {

			cal.add(Calendar.MONTH, i);
			month.setText(simpleDateFormat.format(cal.getTime()));
			refresh();
		}

		private void refresh() {
			super.getChildren().clear();
			this.rows = 5; // most of the time 5 rows are ok
			// save a copy to reset the date after our loop
			Date copy = new Date(cal.getTime().getTime());

			// empty cell header of weak-of-year row
			super.getChildren().add(woyCell);

			// Display a styleable row of localized weekday symbols
			DateFormatSymbols symbols = new DateFormatSymbols();
			String[] dayNames = symbols.getShortWeekdays();

			// @TODO use static constants to access weekdays, I suspect we
			// get problems with localization otherwise ( Day 1 = Sunday/ Monday
			// in
			// different timezones
			for (int i = 1; i < 8; i++) { // array starts with an empty field
				CalendarCell calendarCell = new CalendarCell(cal.getTime(),
						dayNames[i]);
				calendarCell.getStyleClass().add("weekday-cell");
				super.getChildren().add(calendarCell);
			}

			// find out which month we're displaying
			cal.set(Calendar.DAY_OF_MONTH, 1);
			final int month = cal.get(Calendar.MONTH);

			int weekday = cal.get(Calendar.DAY_OF_WEEK);

			// if the first day is a sunday we need to rewind 7 days otherwise
			// the
			// code below would only start with the second week. There might be
			// better ways of doing this...
			if (weekday != Calendar.SUNDAY) {
				// it might be possible, that we need to add a row at the end as
				// well...

				Calendar check = Calendar.getInstance();
				check.setTime(new Date(cal.getTime().getTime()));
				int lastDate = check.getActualMaximum(Calendar.DATE);
				check.set(Calendar.DATE, lastDate);
				if ((lastDate + weekday) > 36) {
					rows = 6;
				}

				cal.add(Calendar.DATE, -7);

			}
			cal.set(Calendar.DAY_OF_WEEK, 1);

			// used to identify and style the cell with the selected date;
			Calendar testSelected = Calendar.getInstance();
			testSelected.setTime(selectedDate);

			for (int i = 0; i < (rows); i++) {

				// first column shows the week of year
				CalendarCell calendarCell = new CalendarCell(cal.getTime(), ""
						+ cal.get(Calendar.WEEK_OF_YEAR));
				calendarCell.getStyleClass().add("week-of-year-cell");
				super.getChildren().add(calendarCell);

				// loop through current week
				for (int j = 0; j < columns; j++) {
					String formatted = sdf.format(cal.getTime());
					final CalendarCell dayCell = new CalendarCell(
							cal.getTime(), formatted);
					dayCell.getStyleClass().add("calendar-cell");
					if (cal.get(Calendar.MONTH) != month) {
						dayCell.getStyleClass().add("calendar-cell-inactive");
					} else {
						if (isSameDay(testSelected, cal)) {
							dayCell.getStyleClass().add(
									"calendar-cell-selected");
							selectedDayCell = dayCell;
						}
						if (isToday(cal)) {
							dayCell.getStyleClass().add("calendar-cell-today");
						}

					}
					dayCell.setOnMouseClicked(new EventHandler<MouseEvent>() {

						@Override
						public void handle(MouseEvent arg0) {
							if (selectedDayCell != null) {
								selectedDayCell.getStyleClass().add(
										"calendar-cell");
								selectedDayCell.getStyleClass().remove(
										"calendar-cell-selected");
							}
							selectedDate.setTime(dayCell.getDate().getTime());
							dayCell.getStyleClass().remove("calendar-cell");
							dayCell.getStyleClass().add(
									"calendar-cell-selected");
							selectedDayCell = dayCell;
							Calendar checkMonth = Calendar.getInstance();
							checkMonth.setTime(dayCell.getDate());

							if (checkMonth.get(Calendar.MONTH) != month) {
								forward(checkMonth.get(Calendar.MONTH) - month);
							}
						}
					});

					// grow the hovered cell in size
					dayCell.setOnMouseEntered(new EventHandler<MouseEvent>() {

						@Override
						public void handle(MouseEvent e) {
							dayCell.setScaleX(1.1);
							dayCell.setScaleY(1.1);
						}
					});

					dayCell.setOnMouseExited(new EventHandler<MouseEvent>() {

						@Override
						public void handle(MouseEvent e) {
							dayCell.setScaleX(1);
							dayCell.setScaleY(1);
						}
					});

					super.getChildren().add(dayCell);
					cal.add(Calendar.DATE, 1); // number of days to add
				}
			}
			cal.setTime(copy);
		}

		/**
		 * Overriden, don't add Children directly
		 * 
		 * @return unmodifieable List
		 */
		@Override
		protected ObservableList<Node> getChildren() {
			return FXCollections
					.unmodifiableObservableList(super.getChildren());
		}

		/**
		 * get the current month our calendar displays. Should always give you
		 * the correct one, even if some days of other mnths are also displayed
		 * 
		 * @return
		 */
		public Date getShownMonth() {
			return cal.getTime();
		}

		@Override
		protected void layoutChildren() {
			ObservableList<Node> children = getChildren();
			double width = getWidth();
			double height = getHeight();

			double cellWidth = (width / (columns + 1));
			double cellHeight = height / (rows + 1);

			for (int i = 0; i < (rows + 1); i++) {
				for (int j = 0; j < (columns + 1); j++) {
					if (children.size() <= ((i * (columns + 1)) + j)) {
						break;
					}
					Node get = children.get((i * (columns + 1)) + j);
					layoutInArea(get, j * cellWidth, i * cellHeight, cellWidth,
							cellHeight, 0.0d, HPos.LEFT, VPos.TOP);
				}

			}
		}
	}

	// utility methods

	private static boolean isSameDay(Calendar cal1, Calendar cal2) {
		if (cal1 == null || cal2 == null) {
			throw new IllegalArgumentException("The dates must not be null");
		}
		return (cal1.get(Calendar.ERA) == cal2.get(Calendar.ERA)
				&& cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) && cal1
					.get(Calendar.DAY_OF_YEAR) == cal2
				.get(Calendar.DAY_OF_YEAR));
	}

	private static boolean isToday(Calendar cal) {
		return isSameDay(cal, Calendar.getInstance());
	}
}
