SUMMARY = "All packages required for a base install of Gnome Shell"
SECTION = "x11/wm"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
PR = "r0"

inherit packagegroup distro_features_check

REQUIRED_DISTRO_FEATURES = "x11"

RDEPENDS_${PN} = " \
    packagegroup-core-x11 \
    xinit \
    atk \
    at-spi2-core \
    at-spi2-atk \
    cairo \
    gnome-shell \
    gnome-bluetooth \
    upower \
    pulseaudio \
    librsvg \
    ibus \
    gnome-desktop3 \
    accountsservice \
    gnome-settings-daemon \
"
