DESCRIPTION = "Accounts Service"
LICENSE = "GPLv3"
DEPENDS = " \ 
            glib-2.0 \
            gsettings-desktop-schemas \
            polkit \
            dbus \
          "

LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

SRC_URI = "git://anongit.freedesktop.org/accountsservice.git;protocol=git;branch=master \
           file://0001-strip-out-intl.patch \
           "

FILES_${PN} += "${systemd_system_unitdir}"
FILES_${PN} += "${datadir}"
FILES_${PN} += "${libdir}"

SRCREV="${AUTOREV}"
S = "${WORKDIR}/git"

inherit pkgconfig meson gobject-introspection 

