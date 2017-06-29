cmake_minimum_required(VERSION 3.4.1)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11 -Wall")

include_directories(../vr_mod_2/src/main/cpp/)
include(../vr_mod_2/CMakeLists.txt)

add_library( # Sets the name of the library.
            vr_mod_1
            SHARED

            src/main/cpp/main.cpp )

find_library( # Sets the name of the path variable.
              log-lib

              # Specifies the name of the NDK library that
              # you want CMake to locate.
              log
              EGL
              GLESv2 )

target_link_libraries(vr_mod_1
                      android
                      log
                      vr_mod_2
                      EGL
                      GLESv2)