db.getCollection("user").aggrigate([
  {
    $addFields: {
      search: {
        $concat: [
          {
            $ifNull: ["$fullName", ""],
          },
        ],
      },
    },
  },
  {
    $match: {
      $or: [
        {
          search: {
            $regularExpression: {
              pattern: ".*Savan.*",
              options: "i",
            },
          },
        },
      ],
      softDelete: false,
    },
  },
  {
    $group: {
      _id: null,
      Count: {
        $sum: 1,
      },
    },
  },
  {
    $project: {
      Count: 1,
    },
  },
]);
