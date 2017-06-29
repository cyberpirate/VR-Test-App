cmake_minimum_required(VERSION 3.4.1)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11 -Wall")

add_library( # Sets the name of the library.
            vr_mod_2
            STATIC

            ../vr_mod_2/src/main/cpp/vr_mod_2.cpp )

find_library( # Sets the name of the path variable.
              log-lib

              # Specifies the name of the NDK library that
              # you want CMake to locate.
              log )

target_link_libraries(vr_mod_2
                      android
                      log )