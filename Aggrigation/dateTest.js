db.getCollection("bookPurchaseLog").aggregate({
  $project: {
    yearMonthDayUTC: { $dateToString: { format: "%Y-%m-%d", date: "$date" } },
    timewithOffsetNY: {
      $dateToString: {
        format: "%H:%M:%S:%L%z",
        date: "$date",
        timezone: "America/New_York",
      },
    },
    timewithOffset430: {
      $dateToString: {
        format: "%H:%M:%S:%L%z",
        date: "$date",
        timezone: "+04:30",
      },
    },
    minutesOffsetNY: {
      $dateToString: {
        format: "%Z",
        date: "$date",
        timezone: "America/New_York",
      },
    },
    minutesOffset430: {
      $dateToString: { format: "%Z", date: "$date", timezone: "+04:30" },
    },
  },
});
