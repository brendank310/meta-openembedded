DESCRIPTION = "GNOME Shell Extensions"
LICENSE = "GPLv2"
DEPENDS = " \
            glib-2.0 \
            gsettings-desktop-schemas \
            gjs \
            gnome-desktop3 \
            gdm \
            mutter \
            wayland \
            wayland-protocols \
            evolution-data-server \
            libcroco \
            polkit \
            gnome-bluetooth \
            gstreamer \
            keybinder \
            gnome-settings-daemon \
            ibus \
            librsvg \
            python3 \
            sassc-native \
          "

LIC_FILES_CHKSUM = "file://COPYING;md5=4cb3a392cbf81a9e685ec13b88c4c101"

SRC_URI = " \
           git://gitlab.gnome.org/GNOME/gnome-shell-extensions.git;protocol=http;branch=master;tag=3.30.1 \
          "

RDEPENDS_gnome-shell = " \
                         gnome-shell \
                        "
S = "${WORKDIR}/git"

EXTRA_OEMESON += " -Dextension_set=all "

FILES_${PN} += "${datadir}"

inherit pkgconfig meson gobject-introspection gettext
