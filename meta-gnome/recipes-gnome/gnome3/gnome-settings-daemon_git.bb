DESCRIPTION = "GNOME Settings Daemon"
LICENSE = "GPLv2"
DEPENDS = " \
           libcanberra \
           prelink \
           glib-2.0 \
           gsettings-desktop-schemas \
           gnome-desktop3 \
           wayland \
           wayland-protocols \
           gettext-native \
           polkit \
           upower \
           libnotify \
           geocode-glib \
           libgweather \
           lcms2 \
           libwacom \
           networkmanager \
           geoclue \
          "

LIC_FILES_CHKSUM = "file://COPYING;md5=59530bdf33659b29e73d4adb9f9f6552"

SRC_URI = "git://gitlab.gnome.org/GNOME/gnome-settings-daemon.git;protocol=http;branch=gnome-3-30 \
           file://0001-remove-extraneous-plugins.patch \
           "

SRCREV="${AUTOREV}"
S = "${WORKDIR}/git"

inherit pkgconfig meson gobject-introspection

EXTRA_OEMESON += " -Denable-gtk-doc=false -Dcups=false "

FILES_${PN} += "${datadir}"
FILES_${PN} += "${libdir}"

do_configure_prepend() {
	# Fixup the gsettings version
	sed -i 's^3.27.90^3.24.1^g' ${S}/meson.build
}

