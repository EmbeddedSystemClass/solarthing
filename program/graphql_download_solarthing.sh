#!/usr/bin/env sh

BASEDIR=$(dirname "$0")
cd "$BASEDIR" || exit 1

# shellcheck source=.scripts/export_version.sh
. .scripts/export_version.sh || exit 1

if ! ls ".downloads/solarthing-graphql-$SOLARTHING_VERSION.jar" 1>/dev/null 2>&1; then
  echo Going to download version: "$SOLARTHING_VERSION" GraphQL
  mkdir ".downloads" 2>/dev/null
  (cd .downloads && wget "https://github.com/wildmountainfarms/solarthing/releases/download/v$SOLARTHING_VERSION/solarthing-graphql-$SOLARTHING_VERSION.jar") || exit 1
else
  echo Already downloaded
fi
ln -sf "../.downloads/solarthing-graphql-$SOLARTHING_VERSION.jar" graphql/solarthing-graphql.jar || exit 1
echo Using SolarThing GraphQL Version: "$SOLARTHING_VERSION"
