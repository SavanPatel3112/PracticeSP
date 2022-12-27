db.getCollection("users").aggregate([
  { $match: { softDelete: false } },
  { $set: { year: { $year: "$date" }, month: { $month: "$date" } } },
  { $match: { year: 2022 } },
  {
    $group: {
      _id: "$month",
      month: { $first: "$month" },
      year: { $first: "$year" },
      count: { $sum: 1 },
      userIds: { $push: { $toString: "$_id" } },
    },
  },
  { $sort: { month: 1 } },
]);
