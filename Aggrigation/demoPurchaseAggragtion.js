db.getCollection("users").aggregate([
  { $set: { month: { $month: "$date" }, year: { $year: "$date" } } },
  { $match: { year: "2021" } },
  {
    $group: {
      month: { $first: "$month" },
      userIds: { $push: { $toString: "$_id" } },
      count: { $sum: 1 },
      _id: { month: "$month", bookName: "$bookName" },
    },
  },
  {
    $group: {
      bookData: {
        $push: { month: "$month", userIds: "$userIds", count: "$count" },
      },
      _id: "$_id.bookName",
    },
  },
  { $unwind: { path: "$bookData" } },
  {
    $group: {
      bookData: { $push: { count: "$bookData.count", bookName: "$_id" } },
      _id: "$bookData.month",
      totalCount: { $sum: "$bookData.count" },
    },
  },
]);
