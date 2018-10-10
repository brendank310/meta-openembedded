DESCRIPTION = "GNOME Weather Library"
LICENSE = "GPLv2"
DEPENDS = " \
           gtk+3 \
           glib-2.0 \
           libsoup-2.4 \
           libxml2 \
           geocode-glib \
          "

LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

SRC_URI = "git://gitlab.gnome.org/GNOME/libgweather.git;protocol=http;branch=gnome-3-28 \
           "

FILES_${PN} += "${datadir}"
FILES_${PN} += "${libdir}"

SRCREV="${AUTOREV}"
S = "${WORKDIR}/git"

inherit pkgconfig meson gobject-introspection

