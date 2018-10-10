DESCRIPTION = "Mutter (Gnome 3 window manager)"
LICENSE = "GPLv2"
DEPENDS = " \
           glib-2.0 \
           gsettings-desktop-schemas \
           wayland-native \
           wayland-protocols \
           libxinerama \
           libinput \
           gtk+3 \
           gnome-desktop3 \
           libxcursor \
           libxkbfile \
           cogl-1.0 \
           clutter-1.0 \
          "

LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

SRC_URI = " \
           git://gitlab.gnome.org/GNOME/mutter.git;protocol=http;branch=master \
           file://0001-disable-zenity-check.patch \
           file://0002-fixup-introspection-variables-with-correct-path.patch \
           file://0003-packageconfig-variable-fixup.patch \
           file://0004-fix-broken-includes.patch \
          "

SRCREV="${AUTOREV}"
S = "${WORKDIR}/git"

inherit autotools pkgconfig distro_features_check gobject-introspection gettext

FILES_${PN} += "${datadir}"

do_configure_prepend() {
	# Autotools expects config.rpath to be with in the source tree
	install -d ${S}/build-aux
	cp ${STAGING_DIR_NATIVE}${datadir}/gettext/config.rpath ${S}/build-aux/config.rpath

        # There are several Werrors that trip when building with Wayland enabled:
	# -Wno-error=implicit-function-declaration -Wno-error=nested-externs -Wno-error=int-conversion
	# and setting those as no-error does not seem to get picked up (it does appear in the compilation
	# command
	sed -i 's^-Werror -Wno-error=deprecated-declarations^-Wno-error=deprecated-declarations^g' ${S}/configure.ac
}

do_compile_prepend() {
	export GIR_EXTRA_LIBS_PATH="${B}/cogl/cogl/.libs:${B}/cogl/cogl-pango/.libs:${B}/cogl/cogl-path/.libs:${B}/clutter/clutter/.libs"
}

do_install_append() {
	install -d ${D}/${datadir}/gir-1.0
	install ${B}/src/Meta-3.gir ${D}/${datadir}/gir-1.0
	install ${B}/cogl/cogl/Cogl-3.gir ${D}/${datadir}/gir-1.0
	install ${B}/cogl/cogl-pango/CoglPango-3.gir ${D}/${datadir}/gir-1.0
	install ${B}/clutter/clutter/Cally-3.gir ${D}/${datadir}/gir-1.0
	install ${B}/clutter/clutter/ClutterX11-3.gir ${D}/${datadir}/gir-1.0
	install ${B}/clutter/clutter/Clutter-3.gir ${D}/${datadir}/gir-1.0
}
