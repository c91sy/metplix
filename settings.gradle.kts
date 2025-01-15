rootProject.name = "metplix"

include("metplix-apps:app-api")
include("metplix-apps:app-batch")

include("metplix-adapters:adapter-http")
include("metplix-adapters:adapter-persistence")
include("metplix-adapters:adapter-mysql")

include("metplix-commons")

include("metplix-core:core-domain")
include("metplix-core:core-port")
include("metplix-core:core-service")
include("metplix-core:core-usecase")