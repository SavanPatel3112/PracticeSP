db.getCollection("userData").aggregate([
  {
    $addFields: {
      search: {
        $concat: [
          { $ifNull: ["$firstName", ""] },
          "|@|",
          { $ifNull: ["$middleName", ""] },
          "|@|",
          { $ifNull: ["$lastName", ""] },
          "|@|",
          { $ifNull: ["$email", ""] },
        ],
      },
    },
  },
  {
    $match: {
      $or: [
        {
          search: {
            $regularExpression: { pattern: ".*savan.*", options: "i" },
          },
        },
      ],
      gender: "MALE",
      softDelete: false,
    },
  },
  { $group: { _id: null, count: { $sum: 1 } } },
  { $project: { count: 1 } },
]);
