CREATE TABLE "tripLog" (
    `id` INTEGER PRIMARY KEY,
	`dateTrip`	INTEGER,
	`latitude`	NUMERIC,
	`longitude`	NUMERIC,
	`title`	TEXT,
	`lure`	TEXT,
	`condition`	INTEGER,
	`fishingType` INTEGER,
	`notes`	TEXT
);

CREATE TABLE "tripLogImages" (
	`tripLogId` INTEGER,
	`filename`	TEXT,
	PRIMARY KEY(tripLogId, filename),
	FOREIGN KEY (tripLogId) REFERENCES tripLog(id)
);

CREATE TABLE "fishCaught" (
	`tripLogId` INTEGER,
	`fishId`	INTEGER,
    `fishQty`	INTEGER,
	PRIMARY KEY(tripLogId, fishId),
	FOREIGN KEY (tripLogId) REFERENCES tripLog(id)
);
